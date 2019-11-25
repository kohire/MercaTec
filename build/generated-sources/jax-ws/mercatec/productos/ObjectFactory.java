
package mercatec.productos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mercatec.productos package. 
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

    private final static QName _InsertProduct_QNAME = new QName("http://productos.mercatec/", "insertProduct");
    private final static QName _ModifyProductByImageInBlankResponse_QNAME = new QName("http://productos.mercatec/", "modifyProductByImageInBlankResponse");
    private final static QName _ModifyProductByImageInBlank_QNAME = new QName("http://productos.mercatec/", "modifyProductByImageInBlank");
    private final static QName _DeleteProductResponse_QNAME = new QName("http://productos.mercatec/", "deleteProductResponse");
    private final static QName _DeleteProduct_QNAME = new QName("http://productos.mercatec/", "deleteProduct");
    private final static QName _ModifyProductResponse_QNAME = new QName("http://productos.mercatec/", "modifyProductResponse");
    private final static QName _ModifyProduct_QNAME = new QName("http://productos.mercatec/", "modifyProduct");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mercatec.productos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteProductResponse }
     * 
     */
    public DeleteProductResponse createDeleteProductResponse() {
        return new DeleteProductResponse();
    }

    /**
     * Create an instance of {@link ModifyProductByImageInBlank }
     * 
     */
    public ModifyProductByImageInBlank createModifyProductByImageInBlank() {
        return new ModifyProductByImageInBlank();
    }

    /**
     * Create an instance of {@link InsertProduct }
     * 
     */
    public InsertProduct createInsertProduct() {
        return new InsertProduct();
    }

    /**
     * Create an instance of {@link ModifyProductByImageInBlankResponse }
     * 
     */
    public ModifyProductByImageInBlankResponse createModifyProductByImageInBlankResponse() {
        return new ModifyProductByImageInBlankResponse();
    }

    /**
     * Create an instance of {@link ModifyProduct }
     * 
     */
    public ModifyProduct createModifyProduct() {
        return new ModifyProduct();
    }

    /**
     * Create an instance of {@link ModifyProductResponse }
     * 
     */
    public ModifyProductResponse createModifyProductResponse() {
        return new ModifyProductResponse();
    }

    /**
     * Create an instance of {@link DeleteProduct }
     * 
     */
    public DeleteProduct createDeleteProduct() {
        return new DeleteProduct();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://productos.mercatec/", name = "insertProduct")
    public JAXBElement<InsertProduct> createInsertProduct(InsertProduct value) {
        return new JAXBElement<InsertProduct>(_InsertProduct_QNAME, InsertProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyProductByImageInBlankResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://productos.mercatec/", name = "modifyProductByImageInBlankResponse")
    public JAXBElement<ModifyProductByImageInBlankResponse> createModifyProductByImageInBlankResponse(ModifyProductByImageInBlankResponse value) {
        return new JAXBElement<ModifyProductByImageInBlankResponse>(_ModifyProductByImageInBlankResponse_QNAME, ModifyProductByImageInBlankResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyProductByImageInBlank }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://productos.mercatec/", name = "modifyProductByImageInBlank")
    public JAXBElement<ModifyProductByImageInBlank> createModifyProductByImageInBlank(ModifyProductByImageInBlank value) {
        return new JAXBElement<ModifyProductByImageInBlank>(_ModifyProductByImageInBlank_QNAME, ModifyProductByImageInBlank.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://productos.mercatec/", name = "deleteProductResponse")
    public JAXBElement<DeleteProductResponse> createDeleteProductResponse(DeleteProductResponse value) {
        return new JAXBElement<DeleteProductResponse>(_DeleteProductResponse_QNAME, DeleteProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://productos.mercatec/", name = "deleteProduct")
    public JAXBElement<DeleteProduct> createDeleteProduct(DeleteProduct value) {
        return new JAXBElement<DeleteProduct>(_DeleteProduct_QNAME, DeleteProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://productos.mercatec/", name = "modifyProductResponse")
    public JAXBElement<ModifyProductResponse> createModifyProductResponse(ModifyProductResponse value) {
        return new JAXBElement<ModifyProductResponse>(_ModifyProductResponse_QNAME, ModifyProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://productos.mercatec/", name = "modifyProduct")
    public JAXBElement<ModifyProduct> createModifyProduct(ModifyProduct value) {
        return new JAXBElement<ModifyProduct>(_ModifyProduct_QNAME, ModifyProduct.class, null, value);
    }

}
