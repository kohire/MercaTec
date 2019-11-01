/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GestorBD;
import Model.MD5;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Aideé Alvarez
 */
@WebServlet(name = "newUser", urlPatterns = {"/newUser"})
public class newUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        int aux = Integer.parseInt(id);
        String nombre = request.getParameter("nombre");
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("pass");
        MD5 md5 = new MD5(contraseña);
        System.out.println(contraseña);
        String tipo = request.getParameter("tipo");
        String correo = request.getParameter("correo");
        GestorBD query = new GestorBD();
        String nick = query.getNickname(usuario);
        try {
            System.out.println("Nickname encontrado:" + nick + ", Nombre que ingresa el admin: " + usuario);

            if (usuario.equalsIgnoreCase(nick)) {
                request.setAttribute("nameError", "El usuario/nickname ya existe. ");
                request.getRequestDispatcher("users.jsp").forward(request, response);
            } else if (nick.equals("")) {
                if (query.insertUser(new Usuario(nombre, usuario, md5.getHashedpasswd().toString(), tipo, correo))) {
                    query.insertUserCar(query.getUsuario(usuario, md5.getHashedpasswd().toString()));
                    response.sendRedirect("listUsers.jsp");
                }
            }

        } catch (IOException | ServletException e) {
            System.out.println("Problem with new user servlet. Check");
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

}
