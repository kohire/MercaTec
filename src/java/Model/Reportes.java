package Model;

public class Reportes {
    private int idReporte;
    private int idUsuario;
    private int  idProducto;
    private String motivo;
    private String descripcion;
    
    public Reportes(){
        
    }

    public Reportes(int idUsuario, int idProducto, String motivo, String descripcion) {
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.motivo = motivo;
        this.descripcion = descripcion;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
