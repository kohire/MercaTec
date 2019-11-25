
package mercatec.carrito;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mercatec.carrito package. 
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

    private final static QName _DeleteProductCarrito_QNAME = new QName("http://carrito.mercatec/", "deleteProductCarrito");
    private final static QName _InsertProductCarrito_QNAME = new QName("http://carrito.mercatec/", "insertProductCarrito");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mercatec.carrito
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteProductCarrito }
     * 
     */
    public DeleteProductCarrito createDeleteProductCarrito() {
        return new DeleteProductCarrito();
    }

    /**
     * Create an instance of {@link InsertProductCarrito }
     * 
     */
    public InsertProductCarrito createInsertProductCarrito() {
        return new InsertProductCarrito();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProductCarrito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://carrito.mercatec/", name = "deleteProductCarrito")
    public JAXBElement<DeleteProductCarrito> createDeleteProductCarrito(DeleteProductCarrito value) {
        return new JAXBElement<DeleteProductCarrito>(_DeleteProductCarrito_QNAME, DeleteProductCarrito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertProductCarrito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://carrito.mercatec/", name = "insertProductCarrito")
    public JAXBElement<InsertProductCarrito> createInsertProductCarrito(InsertProductCarrito value) {
        return new JAXBElement<InsertProductCarrito>(_InsertProductCarrito_QNAME, InsertProductCarrito.class, null, value);
    }

}
