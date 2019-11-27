package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorBD {

    private final  Connection conexion;
    private ResultSet rs;
    private Statement st;
    private Producto producto;
    private ArrayList<Producto> productos;
    //Arrays para carrito
    private Carrito carrito;
    private PreparedStatement ps;
    public String typeUser = "";
    private Usuario usuario;

    public GestorBD() {
        conexion = ConexionBD.obtenerConexion();
    }

    public String getNameUser(int id) {
        String aux = "";
        try {
           String sql = "CALL getNameUser(?)";
           ps = conexion.prepareStatement(sql);
           ps.setInt(1, id);
           rs = ps.executeQuery();
            while (rs.next()) {
                aux = rs.getString("nombre");
            }
            rs.close();
            st.close();
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

 
    
     public List<Reportes> getUniqueReport(int id) {
        List<Reportes> reports = new ArrayList<>();
        try {
            String sql = "CALL selectReport(?)";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
             Reportes rep = new Reportes();
            while (rs.next()) {
                rep.setIdReporte(rs.getInt("idReporte"));
                rep.setIdUsuario(rs.getInt("idUsuario"));
                rep.setIdProducto(rs.getInt("idProducto"));
                rep.setMotivo(rs.getString("motivo"));
                rep.setDescripcion(rs.getString("descripcion"));
                reports.add(rep);
            }
            rs.close(); 
            ps.close();
            System.out.println(reports);
            return reports;
        } catch (SQLException e) {
            System.out.println("Exception caught in get reports: ");
            e.printStackTrace();
            return null;
        }
    }




    // Carrrito y Productos, parte 2.
    public ArrayList<Producto> selectProducts(int id) {
        productos = new ArrayList();
        System.out.println(id);
        try {
            if (id != -1) {
                ps = conexion.prepareStatement("select * from productos where idUsuario=?");
                ps.setInt(1, id);
            } else {
                ps = conexion.prepareStatement("select * from productos");
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                producto = new Producto(
                        rs.getInt(1),
                        rs.getString(3),
                        rs.getBlob(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
                producto.setIdUsuario(rs.getInt(2));
                productos.add(producto);

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return productos;
    }

    public Producto selectProduct(int id) {
        try {
            String sql = "CALL selectProduct(?)";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto(
                        rs.getInt(1),
                        rs.getString(3),
                        rs.getBlob(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
                producto.setIdUsuario(rs.getInt(2));
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
            ps = conexion.prepareStatement("CALL selectCarrito(?)");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                productos.add(new Producto(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getBlob(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8)
                ));
            }
            carrito.setProductos(productos);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return carrito;
    }

  
    public ArrayList<Producto> searchProducto(String productoS) {
        productos = new ArrayList();
        try {
            ps = conexion.prepareStatement("select * from productos");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(3).toLowerCase().contains(productoS.toLowerCase())) {
                    producto = new Producto(
                            rs.getInt(1),
                            rs.getString(3),
                            rs.getBlob(4),
                            rs.getString(5),
                            rs.getDouble(6),
                            rs.getInt(7),
                            rs.getInt(8)
                    );
                    producto.setIdUsuario(rs.getInt(2));
                    productos.add(producto);
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return productos;
    }

    public Usuario showUsuarioProduct(int idUsuario) {
        usuario = new Usuario();
        try {
            ps = conexion.prepareStatement("CALL showUserProduct(?)");
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setNombre(rs.getString("usuario"));
                usuario.setCorreo(rs.getString("correo"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return usuario;
    }
    public ArrayList<Comentario> getComentarios(int idProducto){
        ArrayList<Comentario> comentarios = new ArrayList();
        try{
            ps = conexion.prepareStatement("CALL getComments(?)");
            ps.setInt(1, idProducto);
            rs = ps.executeQuery();
            while(rs.next()){
                String comment = rs.getString(1);
                comentarios.add(
                        new Comentario(
                              this.showUsuarioProduct(rs.getInt(2)).getNombre(),
                              comment
                        )
                );
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return comentarios;
    }
    
    
    public boolean wasBoughtByCustomer(int idUsuario, int idProducto){
        try {
            ps = conexion.prepareStatement("CALL wasBoughtByCustomer(?,?)");
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
