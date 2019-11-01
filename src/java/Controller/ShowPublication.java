package Controller;

import Model.GestorBD;
import Model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Isaac Perez
 */
@WebServlet(name = "ShowPublication", urlPatterns = {"/ShowPublication"})
public class ShowPublication extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idProducto;
        int idUsuario = 0;
        GestorBD query = new GestorBD();
        Producto producto;
        if(request.getParameter("comentario")!=null){
            String comentario = request.getParameter("comentario");
            idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            idProducto = Integer.parseInt(request.getParameter("idProducto"));
            System.out.println("Si ahuevo respondo :3");
            query.comentar(idProducto, idUsuario, comentario);
            producto = query.selectProduct(idProducto);
                request.setAttribute("producto", producto);
                request.setAttribute("idProductRequest", producto.getIdProducto());
                request.getRequestDispatcher("showPublication.jsp").forward(request, response);
        }else if(request.getParameter("idProducto")!=null){
            idProducto = Integer.parseInt(request.getParameter("idProducto"));
            producto = query.selectProduct(idProducto);
            request.setAttribute("producto", producto);
            request.setAttribute("idProductRequest", producto.getIdProducto());
            request.getRequestDispatcher("showPublication.jsp").forward(request, response);
        }else if(request.getParameter("addCar")!=null){
            if((int)request.getSession().getAttribute("id")!=-1){
                int numberItems = Integer.parseInt(request.getParameter("numberOfItem"));
                idUsuario = (int) request.getSession().getAttribute("id");    
                
                idProducto = Integer.parseInt(request.getParameter("addCar"));
                for(int i=0;i<numberItems;i++){
                    query.insertProductCarrito(
                            idUsuario
                            ,idProducto);
                }
                producto = query.selectProduct(idProducto);
                request.setAttribute("producto", producto);
                request.setAttribute("idProductRequest", producto.getIdProducto());
                System.out.println(producto.getIdProducto());
                request.getRequestDispatcher("showPublication.jsp").forward(request, response);
            }else{
                response.sendRedirect("login.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
