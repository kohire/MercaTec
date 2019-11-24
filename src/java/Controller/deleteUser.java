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

/**
 *
 * @author Aideé Alvarez
 */
@WebServlet(name = "deleteUser", urlPatterns = {"/deleteUser"})
public class deleteUser extends HttpServlet {

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
        
        try {
            int idUser = Integer.parseInt(request.getParameter("id"));
            int aux = getIDCar(idUser);
            
            if(deleteUserCar(aux)){
                deleteUser(idUser);
                deleteTheirProducts(idUser);
                deleteTheirComments(idUser);
                request.getRequestDispatcher("/listUsers.jsp").forward(request, response);
            }
        } catch (Exception e) {
                e.printStackTrace();
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

    private static int getIDCar(int id) {
        mercatec.usuarios.UsuarioWS_Service service = new mercatec.usuarios.UsuarioWS_Service();
        mercatec.usuarios.UsuarioWS port = service.getUsuarioWSPort();
        return port.getIDCar(id);
    }

    private static boolean deleteUserCar(int id) {
        mercatec.usuarios.UsuarioWS_Service service = new mercatec.usuarios.UsuarioWS_Service();
        mercatec.usuarios.UsuarioWS port = service.getUsuarioWSPort();
        return port.deleteUserCar(id);
    }

    private static boolean deleteUser(int id) {
        mercatec.usuarios.UsuarioWS_Service service = new mercatec.usuarios.UsuarioWS_Service();
        mercatec.usuarios.UsuarioWS port = service.getUsuarioWSPort();
        return port.deleteUser(id);
    }

    private static boolean deleteTheirProducts(int id) {
        mercatec.usuarios.UsuarioWS_Service service = new mercatec.usuarios.UsuarioWS_Service();
        mercatec.usuarios.UsuarioWS port = service.getUsuarioWSPort();
        return port.deleteTheirProducts(id);
    }

    private static boolean deleteTheirComments(int id) {
        mercatec.usuarios.UsuarioWS_Service service = new mercatec.usuarios.UsuarioWS_Service();
        mercatec.usuarios.UsuarioWS port = service.getUsuarioWSPort();
        return port.deleteTheirComments(id);
    }

    
    
    
    
}
