/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GestorBD;
import Model.Producto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Isaac Perez
 */
@WebServlet(name = "carritoServlet", urlPatterns = {"/carrito"})
public class Carrito extends HttpServlet {

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
        
        GestorBD queries = new GestorBD();
        if((int)request.getSession().getAttribute("id")!= -1){
            if(request.getParameter("id")!=null){
                queries.insertProductCarrito(
                        Integer.parseInt(request.getSession().getAttribute("id").toString())
                        ,Integer.parseInt(request.getParameter("id")));
                response.sendRedirect(request.getParameter("requestURL"));
            }else if(request.getParameter("idDelete")!=null){
                if(!request.getParameter("searchValue").equals("")){
                    System.out.println("ENTREEEEE desde busqueda");
                    queries.deleteProductCarrito(Integer.parseInt(request.getParameter("idDelete")));
                    String searchValue = request.getParameter("searchValue");
                    ArrayList<Producto> productos = queries.searchProducto(
                        searchValue
                    );
                    request.setAttribute("productos", productos);
                    request.setAttribute("searchValue", searchValue);
                    request.getRequestDispatcher("search.jsp").forward(request, response);
                }else if(!request.getParameter("idProductRequest").equals("0")){
                    queries.deleteProductCarrito(Integer.parseInt(request.getParameter("idDelete")));
                    int idProductRequest = Integer.parseInt(request.getParameter("idProductRequest"));
                    Producto producto = queries.selectProduct(idProductRequest);
                    request.setAttribute("producto", producto);
                    request.setAttribute("idProductRequest", idProductRequest);
                    request.getRequestDispatcher("showPublication.jsp").forward(request, response);
                } else{
                    int prueba = Integer.parseInt(request.getParameter("idProductRequest"));
                    queries.deleteProductCarrito(Integer.parseInt(request.getParameter("idDelete")));
                    response.sendRedirect(request.getParameter("requestURL"));
                }
            }else if(request.getParameter("show")!=null){
                response.sendRedirect("showCar.jsp");
            }else if(request.getParameter("buy")!=null){
                
            }else if(request.getParameter("idDeleteT")!=null){
                queries.deleteProductCarrito(
                        Integer.parseInt(request.getParameter("idDeleteT"))
                );
                response.sendRedirect(request.getParameter("requestURL"));
            }else if(request.getParameter("stillShopping")!=null){
                response.sendRedirect("index.jsp");
            }
        }else{
            response.sendRedirect("login.jsp");
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
