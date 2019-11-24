
package mercatec.login;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mercatec.login package. 
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

    private final static QName _LoginResponse_QNAME = new QName("http://login.mercatec/", "loginResponse");
    private final static QName _Login_QNAME = new QName("http://login.mercatec/", "login");
    private final static QName _UserTypeResponse_QNAME = new QName("http://login.mercatec/", "userTypeResponse");
    private final static QName _UserType_QNAME = new QName("http://login.mercatec/", "userType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mercatec.login
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link UserType }
     * 
     */
    public UserType createUserType() {
        return new UserType();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link UserTypeResponse }
     * 
     */
    public UserTypeResponse createUserTypeResponse() {
        return new UserTypeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://login.mercatec/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://login.mercatec/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://login.mercatec/", name = "userTypeResponse")
    public JAXBElement<UserTypeResponse> createUserTypeResponse(UserTypeResponse value) {
        return new JAXBElement<UserTypeResponse>(_UserTypeResponse_QNAME, UserTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://login.mercatec/", name = "userType")
    public JAXBElement<UserType> createUserType(UserType value) {
        return new JAXBElement<UserType>(_UserType_QNAME, UserType.class, null, value);
    }

}
