package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aideé Alvarez
 */
public class ConexionBD {

    //cambiar de acuerdo a su nombre de usuario y contraseña
    private static Connection conexion;
    private static final String database = "mercatec";
    private static final String user = "root";
    private static final String password = "";

    public static Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/"+database
                    , user
                    , password
            );
            System.out.println("Done!");
            return conexion;
        } catch (Exception e) {
            System.out.println("Error en la conexion..."+e);
            return null;
        }
    }

    public Connection closeConnection (){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}