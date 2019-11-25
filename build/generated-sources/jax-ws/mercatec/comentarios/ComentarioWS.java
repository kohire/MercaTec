
package mercatec.comentarios;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ComentarioWS", targetNamespace = "http://comentarios.mercatec/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ComentarioWS {


    /**
     * 
     * @param idUsuario
     * @param idProducto
     * @param comentario
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "comentar", targetNamespace = "http://comentarios.mercatec/", className = "mercatec.comentarios.Comentar")
    @Action(input = "http://comentarios.mercatec/ComentarioWS/comentar")
    public void comentar(
        @WebParam(name = "idUsuario", targetNamespace = "")
        int idUsuario,
        @WebParam(name = "idProducto", targetNamespace = "")
        int idProducto,
        @WebParam(name = "comentario", targetNamespace = "")
        String comentario);

}
