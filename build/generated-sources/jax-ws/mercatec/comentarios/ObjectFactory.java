
package mercatec.comentarios;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mercatec.comentarios package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Comentar_QNAME = new QName("http://comentarios.mercatec/", "comentar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mercatec.comentarios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Comentar }
     * 
     */
    public Comentar createComentar() {
        return new Comentar();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comentar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comentarios.mercatec/", name = "comentar")
    public JAXBElement<Comentar> createComentar(Comentar value) {
        return new JAXBElement<Comentar>(_Comentar_QNAME, Comentar.class, null, value);
    }

}
