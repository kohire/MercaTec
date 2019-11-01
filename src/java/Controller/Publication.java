/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import Model.GestorBD;
import Model.Producto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;
/**
 *
 * @author Isaac Perez
 */
@WebServlet(name = "Publication", urlPatterns = {"/Publication"})
@MultipartConfig
public class Publication extends HttpServlet {
    private Part imagen;
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
       String nombre = request.getParameter("nombre");
       String descripcion = request.getParameter("descripcion");
       double precio = Double.parseDouble(request.getParameter("precio"));
       int unidades = Integer.parseInt(request.getParameter("unidades"));
       Part imagen = request.getPart("imagen");
       GestorBD query = new GestorBD();
       
       String extension[] = imagen.getContentType().split("/");
        String text="";
        try {

            BufferedImage image = ImageIO.read(imagen.getInputStream());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, extension[1], outputStream);
            text = new String(Base64.getEncoder().encode(outputStream.toByteArray()));
        }catch(Exception e){
                System.out.println(e);
        }
        int id = (int) request.getSession().getAttribute("id");
        query.insertProduct(id, new Producto(
                nombre,
                text,
                descripcion,
                precio,
                1,
                unidades
        ));
        response.sendRedirect("myAccount.jsp");
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
