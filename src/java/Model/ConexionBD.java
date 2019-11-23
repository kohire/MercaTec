package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aideé Alvarez
 * 
 * Conexión Singleton a la base de datos.
 */
public class ConexionBD {

    //cambiar de acuerdo a su nombre de usuario y contraseña.
    private static Connection conn;
    private static final String database = "mercatec";
    private static final String user     = "root";
    private static final String password = "";
    private static final String path     = "jdbc:mysql://localhost/" + database;
    private String driver                = "com.mysql.jdbc.Driver";
    private static ConexionBD myConn;

    private ConexionBD() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(path, user, password);
            System.out.println("Ready!! -- Connection to MySQL successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection obtenerConexion() {
        if (conn == null) {
            myConn = new ConexionBD();
        } else {
            System.out.println("Ya existe una conexión con la base de datos.");
        }
        return conn;
    }

}
