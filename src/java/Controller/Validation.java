package Controller;

import Model.GestorBD;
import Model.MD5;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
/**
 *
 * @author Aideé Alvarez
 */
@WebServlet(name = "validacionUsuario", urlPatterns = {"/validacionUsuario"})
public class Validation extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            // Primero traerse los parámetros del html.
            String usuario = request.getParameter("user");
            String pass = request.getParameter("password");
            
            //Encriptacion!!!!
            MD5 md5 = new MD5(pass);
            // Llamar al gestor de base de datos para realizar la búsqueda.
                     GestorBD gestor = new GestorBD();
             int id  = gestor.getUsuario(usuario, md5.getHashedpasswd().toString());
             String aux = gestor.typeUser;
            if(id != 0){
                // Si regresa algo que no sea -1, se crea una sesión de usuario.
                // y se obtiene su id con su tipo de usuario.
                HttpSession session = request.getSession(true);
                session.setAttribute( "id", id );
                session.setAttribute("type", aux);
                response.sendRedirect("index.jsp");
        }else{
                request.setAttribute("LogError", "El usuario o contraseña son incorrectos");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
    }
}
