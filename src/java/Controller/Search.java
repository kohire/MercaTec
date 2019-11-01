/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GestorBD;
import Model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {

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
        GestorBD queries = new GestorBD();
        if (request.getParameter("id") != null) {
            if ((int)request.getSession().getAttribute("id") != -1) {
                queries.insertProductCarrito(
                        Integer.parseInt(request.getSession().getAttribute("id")
                                .toString()), Integer.parseInt(request.getParameter("id")));
                refreshSearch(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        } else if (request.getParameter("searchValue") != null) {
            String searchValue = request.getParameter("searchValue");
            ArrayList<Producto> productos = queries.searchProducto(
                    searchValue
            );
            request.setAttribute("productos", productos);
            request.setAttribute("searchValue", searchValue);
            request.getRequestDispatcher("search.jsp").forward(request, response);
        }

    }
        
    public void refreshSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        GestorBD queries = new GestorBD();
        String searchValue = request.getParameter("searchValue");
        ArrayList<Producto> productos = queries.searchProducto(
            searchValue
        );
        request.setAttribute("productos", productos);
        request.setAttribute("searchValue", searchValue);
        request.getRequestDispatcher("search.jsp").forward(request, response);
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
