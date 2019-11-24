package Controller;

import Model.MD5;
import java.io.IOException;
import java.io.PrintWriter;
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
                     
             int id  = login(usuario, md5.getHashedpasswd().toString());
             String aux = userType();
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

    private static int login(java.lang.String nombre, java.lang.String pass) {
        mercatec.login.LoginWS_Service service = new mercatec.login.LoginWS_Service();
        mercatec.login.LoginWS port = service.getLoginWSPort();
        return port.login(nombre, pass);
    }

    private static String userType() {
        mercatec.login.LoginWS_Service service = new mercatec.login.LoginWS_Service();
        mercatec.login.LoginWS port = service.getLoginWSPort();
        return port.userType();
    }
    
}
