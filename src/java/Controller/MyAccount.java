/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Producto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Isaac Perez
 */
@WebServlet(name = "MyAccount", urlPatterns = {"/MyAccount"})
@MultipartConfig
public class MyAccount extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        BufferedImage image = null;
        Producto producto;
        if(request.getParameter("idDelete")!=null){
            deleteProduct(Integer.parseInt(request.getParameter("idDelete")));
            response.sendRedirect("myPublication.jsp");
        }else if(request.getParameter("idEdit")!=null){
                producto = new Producto(
                        request.getParameter("nombre"),
                        request.getParameter("imagen"),
                        request.getParameter("descripcion"),
                        Double.parseDouble(request.getParameter("precio")),
                        1,
                        Integer.parseInt(request.getParameter("unidades"))
                );
            producto.setIdProducto(Integer.parseInt(request.getParameter("idEdit")));
            request.setAttribute("producto", producto);
            request.getRequestDispatcher("editPublication.jsp").forward(request, response);
        }else if(request.getParameter("edit")!=null){
                Part imagen = request.getPart("imagen");
                String extension[] = imagen.getContentType().split("/");
                String text="";
                try {

                    image = ImageIO.read(imagen.getInputStream());
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    ImageIO.write(image, extension[1], outputStream);
                    text = new String(Base64.getEncoder().encode(outputStream.toByteArray()));
                }catch(Exception e){
                    System.out.println(e);
                }
            if(image!=null){
                modifyProduct(
                    request.getParameter("nombre"),
                    text,
                    request.getParameter("descripcion"),
                    Double.parseDouble(request.getParameter("precio")),
                    1,
                    Integer.parseInt(request.getParameter("unidades")),
                    Integer.parseInt(request.getParameter("id"))
                );
            }else{
                modifyProductByImageInBlank(
                    request.getParameter("nombre"),
                    request.getParameter("imageActualValue"),
                    request.getParameter("descripcion"),
                    Double.parseDouble(request.getParameter("precio")),
                    1,
                    Integer.parseInt(request.getParameter("unidades")),
                    Integer.parseInt(request.getParameter("id"))
                );
            }
            response.sendRedirect("myPublication.jsp");
        }
        
    }

        private static void modifyProduct(java.lang.String nombre,
            java.lang.String text, java.lang.String descripcion,
            double precio, int existencia, int unidades, int idProd) {
        mercatec.productos.ProductoWS_Service service = 
                new mercatec.productos.ProductoWS_Service();
        mercatec.productos.ProductoWS port = service.getProductoWSPort();
        port.modifyProduct(nombre, text, descripcion, precio, existencia,
                unidades, idProd);
    }

    private static void modifyProductByImageInBlank(java.lang.String nombre,
            java.lang.String text, java.lang.String descripcion, double precio,
            int existencia, int unidades, int idProd) {
        mercatec.productos.ProductoWS_Service service = 
                new mercatec.productos.ProductoWS_Service();
        mercatec.productos.ProductoWS port = service.getProductoWSPort();
        port.modifyProductByImageInBlank(nombre, text, descripcion, precio,
                existencia, unidades, idProd);
    }

      private static void deleteProduct(int id) {
        mercatec.productos.ProductoWS_Service service = new mercatec.productos.ProductoWS_Service();
        mercatec.productos.ProductoWS port = service.getProductoWSPort();
        port.deleteProduct(id);
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
