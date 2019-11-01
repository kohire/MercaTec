package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorBD {

    private  Connection conexion;
    private ResultSet rs;
    private Statement st;
    private Producto producto;
    private ArrayList<Producto> productos;
    //Arrays para carrito
    private Carrito carrito;
    private ArrayList<Integer> claveProductos;

    private PreparedStatement ps;
    private PreparedStatement psAux;
    private ResultSet result;

    public String typeUser = "";
    private Usuario usuario;

    public GestorBD() {
        conexion = ConexionBD.obtenerConexion();
    }

    // Login
    public int getUsuario(String us, String pass) {
        int id = 0;
        try {
            System.out.println("us:" +us+ " pass:" + pass);
            String sql = "SELECT idUsuario, tipo FROM Usuario WHERE usuario = '" + us + "' AND contraseña = '" + pass + "' AND estado = 1";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("idUsuario");
                typeUser = rs.getString("tipo");
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al traer el usuario. Favor de checar.");
        }
        return id;
    }

    public String getNameUser(int id) {
        String aux = "";
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT nombre FROM Usuario WHERE idUsuario =" + id);
            while (rs.next()) {
                aux = rs.getString("nombre");
            }
            return aux;
        } catch (Exception e) {
            e.printStackTrace();
            return aux;
        }
    }
    // Usuarios.

    public List<Usuario> getUsuarios(String smt) {
        List<Usuario> users = new ArrayList<>();
        try {
            st = conexion.createStatement();
            if (smt == null) {
                rs = st.executeQuery("SELECT * FROM Usuario WHERE estado = 1 ");
            } else {
                rs = st.executeQuery("SELECT * FROM Usuario WHERE estado = 1 AND "
                        + "nombre LIKE '%" + smt + "%' OR usuario LIKE '%" + smt + "%'");
            }
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setIdUsuario(rs.getInt(1));
                us.setNombre(rs.getString(2));
                us.setUsuario(rs.getString(3));
                us.setContraseña(rs.getString(4));
                us.setTipo(rs.getString(5));
                us.setCorreo(rs.getString(6));
                users.add(us);
            }
            rs.close();
            st.close();
            return users;
        } catch (SQLException e) {
            System.out.println("Exception caught in get users: ");
            e.printStackTrace();
            return null;
        }
    }
    
    public String getNickname(String name){
        String aux = "";
        try{
            st = conexion.createStatement();
             rs = st.executeQuery("SELECT usuario FROM Usuario WHERE usuario = '"+ name + "'");
             if(rs.next()){
                 aux = rs.getString("usuario");
             }
             return aux;
        }catch(Exception e){
            e.printStackTrace();
            return aux;
        }
    }
    
    /* Reportes */
    public List<Reportes> getReports(String smt) {
        List<Reportes> reports = new ArrayList<>();
        try {
            st = conexion.createStatement();
            if (smt == null) {
                rs = st.executeQuery("SELECT * FROM Reporte");
            } else {
                rs = st.executeQuery("SELECT * FROM Reporte WHERE motivo LIKE '%" + smt + "%'");
            }
            while (rs.next()) {
                Reportes rep = new Reportes();
                rep.setIdReporte(rs.getInt(1));
                rep.setIdUsuario(rs.getInt(2));
                rep.setIdProducto(rs.getInt(3));
                rep.setMotivo(rs.getString(4));
                rep.setDescripcion(rs.getString(5));
                reports.add(rep);
            }
            rs.close();
            st.close();
            return reports;
        } catch (SQLException e) {
            System.out.println("Exception caught in get reports: ");
            e.printStackTrace();
            return null;
        }
    }  
    public boolean insertUser(Usuario usuario) {
        try {
            String sql = "INSERT INTO Usuario(idUsuario, nombre, usuario, contraseña, tipo, correo, estado) VALUES \n"
                    + "(NULL, ?,?,?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getContraseña());
            ps.setString(4, usuario.getTipo());
            ps.setString(5, usuario.getCorreo());
            ps.setInt(6, 1);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error caught in: Insertar Usuario BD. Check.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(int id) {
        try {
            String sql = "DELETE FROM Usuario WHERE idUsuario =" + id;
            ps = conexion.prepareCall(sql);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error caught in: delete user. Check.");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteTheirProducts(int id) {
        try {
            String sql = "DELETE FROM Productos WHERE idUsuario =" + id;
            ps = conexion.prepareCall(sql);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error caught in: delete their products. Check.");
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteTheirComments(int id) {
        try {
            String sql = "DELETE FROM Comentarios WHERE idUsuario =" + id;
            ps = conexion.prepareCall(sql);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error caught in: delete their comments. Check.");
            e.printStackTrace();
            return false;
        }
    }
    

    public int getIDfromUser() {
        int id = 0;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("CALL getNextIDUser();");
            rs.next();
            id = rs.getInt(1);
            rs.close();
            st.close();
            return id;
        } catch (Exception e) {
            System.out.println("Error caught in: get id from new user. Check.");
            e.printStackTrace();
            return -1;
        }

    }

    public boolean insertReport(Reportes rep){
        try {
            String sql = "INSERT INTO Reporte(idReporte, idUsuario, idProducto, motivo, descripcion) VALUES \n"
                    + "(NULL,?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, rep.getIdUsuario());
            ps.setInt(2, rep.getIdProducto());
            ps.setString(3, rep.getMotivo());
            ps.setString(4, rep.getDescripcion());
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error caught in: Insertar Reportes. Check.");
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    public boolean deleteReport(int id) {
        try {
            String sql = "DELETE FROM Reporte WHERE idReporte =" + id;
            ps = conexion.prepareCall(sql);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error caught in: delete report. Check.");
            e.printStackTrace();
            return false;
        }
    }

    public List<Reportes> getUniqueReport(int id) {
        List<Reportes> reports = new ArrayList<>();
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM Reporte WHERE idReporte =" + id);
            while (rs.next()) {
                Reportes rep = new Reportes();
                rep.setIdReporte(rs.getInt(1));
                rep.setIdUsuario(rs.getInt(2));
                rep.setIdProducto(rs.getInt(3));
                rep.setMotivo(rs.getString(4));
                rep.setDescripcion(rs.getString(5));
                reports.add(rep);
            }
            rs.close();
            st.close();
            return reports;
        } catch (SQLException e) {
            System.out.println("Exception caught in get reports: ");
            e.printStackTrace();
            return null;
        }
    }

      public boolean deleteSameReports(int id){
        try{
           String sql = "DELETE FROM Reporte WHERE idProducto =" + id;
            ps = conexion.prepareCall(sql);
            ps.execute();
            ps.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    // Carrito, parte 1.
    public boolean insertUserCar(int idUser) {
        try {
            String sql = "INSERT INTO Carrito(idCarrito,idUsuario) VALUES (NULL,?)";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idUser);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error caught in: insert user car.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUserCar(int idCarrito) {
        try {
            String sql = "DELETE FROM Carrito WHERE idCarrito = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idCarrito);
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error caught in: delete user car DB. Check.");
            return false;
        }
    }

    public int getIDCar(int idUser) {
        int idCar = 0;
        try {
            String sql = "SELECT idCarrito FROM Carrito WHERE idUsuario = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            if (rs.next()) {
                idCar = rs.getInt("idCarrito");
            }
            rs.close();
            ps.close();
            return idCar;
        } catch (Exception e) {
            System.out.println("Error caught in: get id car from user in DB. Check");
            e.printStackTrace();
            return -1;
        }
    }

    // Carrrito y Productos, parte 2.
    public ArrayList<Producto> selectProducts(int id) {
        productos = new ArrayList();
        try {
            if (id != -1) {
                ps = conexion.prepareStatement("select * from productos where idUsuario=?");
                ps.setInt(1, id);
            } else {
                ps = conexion.prepareStatement("select * from productos");
            }

            result = ps.executeQuery();
            while (result.next()) {
                producto = new Producto(
                        result.getInt(1),
                        result.getString(3),
                        result.getBlob(4),
                        result.getString(5),
                        result.getDouble(6),
                        result.getInt(7),
                        result.getInt(8)
                );
                producto.setIdUsuario(result.getInt(2));
                productos.add(producto);

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return productos;
    }

    public Producto selectProduct(int id) {
        try {
            ps = conexion.prepareStatement("select * from productos where idProducto=?");
            ps.setInt(1, id);
            result = ps.executeQuery();
            if (result.next()) {
                producto = new Producto(
                        result.getInt(1),
                        result.getString(3),
                        result.getBlob(4),
                        result.getString(5),
                        result.getDouble(6),
                        result.getInt(7),
                        result.getInt(8)
                );
                producto.setIdUsuario(result.getInt(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return producto;
    }

    public Carrito selectCarrito(int id) {
        productos = new ArrayList();
        carrito = new Carrito();
        try {
            int idPC = 0;
            ps = conexion.prepareStatement("select productos_carrito.id,productos.idProducto"
                    + ", productos.nombreProd, "
                    + "productos.imagenProd, productos.descripcion, productos.precio,"
                    + " productos.existencia, productos.unidades "
                    + "from Productos_Carrito inner join carrito "
                    + "on carrito.idCarrito = Productos_Carrito.idCarrito inner join usuario "
                    + "on carrito.idUsuario = usuario.idUsuario inner join productos "
                    + "on Productos_Carrito.idProducto = productos.idProducto "
                    + "where usuario.idUsuario = ?"
            );
            ps.setInt(1, id);
            result = ps.executeQuery();
            while (result.next()) {
                productos.add(new Producto(
                        result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getBlob(4),
                        result.getString(5),
                        result.getDouble(6),
                        result.getInt(7),
                        result.getInt(8)
                ));
            }
            carrito.setProductos(productos);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return carrito;
    }

    public void insertProductCarrito(int idUsuario, int idProducto) {
        try {
            ps = conexion.prepareStatement("select idCarrito from carrito"
                    + " where idUsuario=?"
            );
            ps.setInt(1, idUsuario);
            result = ps.executeQuery();
            int idCarrito = 0;
            if (result.next()) {
                idCarrito = result.getInt(1);
            }
            ps = conexion.prepareStatement("insert into productos_carrito (idCarrito,idProducto)"
                    + " values(?,?)");
            ps.setInt(1, idCarrito);
            ps.setInt(2, idProducto);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteProductCarrito(int idPC) {
        try {
            ps = conexion.prepareStatement("delete from productos_carrito"
                    + " where id=?");
            ps.setInt(1, idPC);
            if (ps.executeUpdate() != 0) {
                System.out.println("Eliminado del carrito");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<Producto> searchProducto(String productoS) {
        productos = new ArrayList();
        try {
            ps = conexion.prepareStatement("select * from productos");
            result = ps.executeQuery();
            while (result.next()) {
                if (result.getString(3).toLowerCase().contains(productoS.toLowerCase())) {
                    producto = new Producto(
                            result.getInt(1),
                            result.getString(3),
                            result.getBlob(4),
                            result.getString(5),
                            result.getDouble(6),
                            result.getInt(7),
                            result.getInt(8)
                    );
                    producto.setIdUsuario(result.getInt(2));
                    productos.add(producto);
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return productos;
    }

    public void insertProduct(int id, Producto producto) {
        try {
            ps = conexion.prepareStatement("insert into productos ("
                    + "idUsuario,"
                    + "nombreProd,"
                    + "imagenProd,"
                    + "descripcion,"
                    + "precio,"
                    + "existencia,"
                    + "unidades"
                    + ") values ("
                    + "?,?,?,?,?,1,?"
                    + ")");
            ps.setInt(1, id);
            ps.setString(2, producto.getNombreProd());
            ps.setBytes(3, producto.getImage().getBytes());
            ps.setString(4, producto.getDecripción());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getUnidades());
            if (ps.executeUpdate() != 0) {
                System.out.println("Producto insertado exitoso");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteProduct(int idProducto) {
        try {
            ps = conexion.prepareStatement("delete from productos where idProducto=?");
            ps.setInt(1, idProducto);
            if (ps.executeUpdate() != 0) {
                System.out.println("Eliminado");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modifyProduct(Producto producto) {
        try {
            ps = conexion.prepareStatement("update productos set "
                    + "nombreProd=?,"
                    + "imagenProd=?,"
                    + "descripcion=?,"
                    + "precio=?,"
                    + "existencia=?,"
                    + "unidades=? where idProducto=?"
            );
            ps.setString(1, producto.getNombreProd());
            ps.setBytes(2, producto.getImage().getBytes());
            ps.setString(3, producto.getDecripción());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getExistencia());
            ps.setInt(6, producto.getUnidades());
            ps.setInt(7, producto.getIdProducto());
            if (ps.executeUpdate() != 0) {
                System.out.println("Producto insertado exitoso");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Usuario showUsuarioProduct(int idUsuario) {
        usuario = new Usuario();
        try {
            ps = conexion.prepareStatement("select * from usuario where idUsuario=?");
            ps.setInt(1, idUsuario);
            result = ps.executeQuery();
            if (result.next()) {
                usuario.setNombre(result.getString(2));
                usuario.setCorreo(result.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return usuario;
    }
    public ArrayList<Comentario> getComentarios(int idProducto){
        ArrayList<Comentario> comentarios = new ArrayList();
        try{
            ps = conexion.prepareStatement("select comentario,idUsuario from comentarios where idProducto=?");
            ps.setInt(1, idProducto);
            rs = ps.executeQuery();
            while(rs.next()){
                comentarios.add(
                        new Comentario(
                              this.showUsuarioProduct(rs.getInt(2)).getNombre(),
                              rs.getString(1)
                        )
                );
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return comentarios;
    }
    
    public void comentar(int idProducto, int idUsuario, String comentario){
        try{
            ps = conexion.prepareStatement("insert into comentarios (idUsuario,idProducto,comentario) "
                    + "values(?,?,?)");
            ps.setInt(1, idUsuario);
            ps.setInt(2, idProducto);
            ps.setString(3, comentario);
            if(ps.executeUpdate()!=0){
                System.out.println("Comentario ingresado");
            }else{
                System.out.println("nel no pude");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public boolean wasBoughtByCustomer(int idUsuario, int idProducto){
        try {
            ps = conexion.prepareStatement("select  productos_carrito.idProducto "+
                    "from carrito inner join productos_carrito " +
                    "on carrito.idCarrito = productos_carrito.idCarrito " +
                    "where carrito.idUsuario=? and  productos_carrito.idProducto=?");
            ps.setInt(1, idUsuario);
            ps.setInt(2, idProducto);
            if(ps.executeQuery().next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
}
