/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Isaac Perez
 */
public class Comentario {
    private int idComentario;
    private int Producto;
    private String comentario;
    private int puntuacion;
    private String nombreUsuario;
    
    public Comentario(){
        
    }
    
    public Comentario(int idComentario, int idUsuario, int Producto, String comentario, int puntuacion) {
        this.idComentario = idComentario;
        this.Producto = Producto;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
    }
    public Comentario(String nombreUsuario, String comentario){
        this.nombreUsuario = nombreUsuario;
        this.comentario = comentario;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    
    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getProducto() {
        return Producto;
    }

    public void setProducto(int Producto) {
        this.Producto = Producto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    
    
}
