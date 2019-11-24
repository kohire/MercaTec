
package mercatec.usuarios;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mercatec.usuarios package. 
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

    private final static QName _DeleteUserCarResponse_QNAME = new QName("http://usuarios.mercatec/", "deleteUserCarResponse");
    private final static QName _InsertUserCarResponse_QNAME = new QName("http://usuarios.mercatec/", "insertUserCarResponse");
    private final static QName _InsertUserResponse_QNAME = new QName("http://usuarios.mercatec/", "insertUserResponse");
    private final static QName _DeleteTheirComments_QNAME = new QName("http://usuarios.mercatec/", "deleteTheirComments");
    private final static QName _InsertUserCar_QNAME = new QName("http://usuarios.mercatec/", "insertUserCar");
    private final static QName _NicknameResponse_QNAME = new QName("http://usuarios.mercatec/", "nicknameResponse");
    private final static QName _GetIDCar_QNAME = new QName("http://usuarios.mercatec/", "getIDCar");
    private final static QName _GetIDCarResponse_QNAME = new QName("http://usuarios.mercatec/", "getIDCarResponse");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://usuarios.mercatec/", "deleteUserResponse");
    private final static QName _User_QNAME = new QName("http://usuarios.mercatec/", "user");
    private final static QName _UserResponse_QNAME = new QName("http://usuarios.mercatec/", "userResponse");
    private final static QName _DeleteTheirCommentsResponse_QNAME = new QName("http://usuarios.mercatec/", "deleteTheirCommentsResponse");
    private final static QName _DeleteUserCar_QNAME = new QName("http://usuarios.mercatec/", "deleteUserCar");
    private final static QName _DeleteUser_QNAME = new QName("http://usuarios.mercatec/", "deleteUser");
    private final static QName _Nickname_QNAME = new QName("http://usuarios.mercatec/", "nickname");
    private final static QName _DeleteTheirProductsResponse_QNAME = new QName("http://usuarios.mercatec/", "deleteTheirProductsResponse");
    private final static QName _InsertUser_QNAME = new QName("http://usuarios.mercatec/", "insertUser");
    private final static QName _DeleteTheirProducts_QNAME = new QName("http://usuarios.mercatec/", "deleteTheirProducts");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mercatec.usuarios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetIDCarResponse }
     * 
     */
    public GetIDCarResponse createGetIDCarResponse() {
        return new GetIDCarResponse();
    }

    /**
     * Create an instance of {@link GetIDCar }
     * 
     */
    public GetIDCar createGetIDCar() {
        return new GetIDCar();
    }

    /**
     * Create an instance of {@link NicknameResponse }
     * 
     */
    public NicknameResponse createNicknameResponse() {
        return new NicknameResponse();
    }

    /**
     * Create an instance of {@link DeleteTheirComments }
     * 
     */
    public DeleteTheirComments createDeleteTheirComments() {
        return new DeleteTheirComments();
    }

    /**
     * Create an instance of {@link InsertUserCar }
     * 
     */
    public InsertUserCar createInsertUserCar() {
        return new InsertUserCar();
    }

    /**
     * Create an instance of {@link DeleteUserCarResponse }
     * 
     */
    public DeleteUserCarResponse createDeleteUserCarResponse() {
        return new DeleteUserCarResponse();
    }

    /**
     * Create an instance of {@link InsertUserCarResponse }
     * 
     */
    public InsertUserCarResponse createInsertUserCarResponse() {
        return new InsertUserCarResponse();
    }

    /**
     * Create an instance of {@link InsertUserResponse }
     * 
     */
    public InsertUserResponse createInsertUserResponse() {
        return new InsertUserResponse();
    }

    /**
     * Create an instance of {@link DeleteTheirProducts }
     * 
     */
    public DeleteTheirProducts createDeleteTheirProducts() {
        return new DeleteTheirProducts();
    }

    /**
     * Create an instance of {@link InsertUser }
     * 
     */
    public InsertUser createInsertUser() {
        return new InsertUser();
    }

    /**
     * Create an instance of {@link DeleteTheirProductsResponse }
     * 
     */
    public DeleteTheirProductsResponse createDeleteTheirProductsResponse() {
        return new DeleteTheirProductsResponse();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link Nickname }
     * 
     */
    public Nickname createNickname() {
        return new Nickname();
    }

    /**
     * Create an instance of {@link DeleteTheirCommentsResponse }
     * 
     */
    public DeleteTheirCommentsResponse createDeleteTheirCommentsResponse() {
        return new DeleteTheirCommentsResponse();
    }

    /**
     * Create an instance of {@link DeleteUserCar }
     * 
     */
    public DeleteUserCar createDeleteUserCar() {
        return new DeleteUserCar();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link UserResponse }
     * 
     */
    public UserResponse createUserResponse() {
        return new UserResponse();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserCarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "deleteUserCarResponse")
    public JAXBElement<DeleteUserCarResponse> createDeleteUserCarResponse(DeleteUserCarResponse value) {
        return new JAXBElement<DeleteUserCarResponse>(_DeleteUserCarResponse_QNAME, DeleteUserCarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertUserCarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "insertUserCarResponse")
    public JAXBElement<InsertUserCarResponse> createInsertUserCarResponse(InsertUserCarResponse value) {
        return new JAXBElement<InsertUserCarResponse>(_InsertUserCarResponse_QNAME, InsertUserCarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "insertUserResponse")
    public JAXBElement<InsertUserResponse> createInsertUserResponse(InsertUserResponse value) {
        return new JAXBElement<InsertUserResponse>(_InsertUserResponse_QNAME, InsertUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTheirComments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "deleteTheirComments")
    public JAXBElement<DeleteTheirComments> createDeleteTheirComments(DeleteTheirComments value) {
        return new JAXBElement<DeleteTheirComments>(_DeleteTheirComments_QNAME, DeleteTheirComments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertUserCar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "insertUserCar")
    public JAXBElement<InsertUserCar> createInsertUserCar(InsertUserCar value) {
        return new JAXBElement<InsertUserCar>(_InsertUserCar_QNAME, InsertUserCar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NicknameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "nicknameResponse")
    public JAXBElement<NicknameResponse> createNicknameResponse(NicknameResponse value) {
        return new JAXBElement<NicknameResponse>(_NicknameResponse_QNAME, NicknameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIDCar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "getIDCar")
    public JAXBElement<GetIDCar> createGetIDCar(GetIDCar value) {
        return new JAXBElement<GetIDCar>(_GetIDCar_QNAME, GetIDCar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIDCarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "getIDCarResponse")
    public JAXBElement<GetIDCarResponse> createGetIDCarResponse(GetIDCarResponse value) {
        return new JAXBElement<GetIDCarResponse>(_GetIDCarResponse_QNAME, GetIDCarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "userResponse")
    public JAXBElement<UserResponse> createUserResponse(UserResponse value) {
        return new JAXBElement<UserResponse>(_UserResponse_QNAME, UserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTheirCommentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "deleteTheirCommentsResponse")
    public JAXBElement<DeleteTheirCommentsResponse> createDeleteTheirCommentsResponse(DeleteTheirCommentsResponse value) {
        return new JAXBElement<DeleteTheirCommentsResponse>(_DeleteTheirCommentsResponse_QNAME, DeleteTheirCommentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserCar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "deleteUserCar")
    public JAXBElement<DeleteUserCar> createDeleteUserCar(DeleteUserCar value) {
        return new JAXBElement<DeleteUserCar>(_DeleteUserCar_QNAME, DeleteUserCar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Nickname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "nickname")
    public JAXBElement<Nickname> createNickname(Nickname value) {
        return new JAXBElement<Nickname>(_Nickname_QNAME, Nickname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTheirProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "deleteTheirProductsResponse")
    public JAXBElement<DeleteTheirProductsResponse> createDeleteTheirProductsResponse(DeleteTheirProductsResponse value) {
        return new JAXBElement<DeleteTheirProductsResponse>(_DeleteTheirProductsResponse_QNAME, DeleteTheirProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "insertUser")
    public JAXBElement<InsertUser> createInsertUser(InsertUser value) {
        return new JAXBElement<InsertUser>(_InsertUser_QNAME, InsertUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTheirProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuarios.mercatec/", name = "deleteTheirProducts")
    public JAXBElement<DeleteTheirProducts> createDeleteTheirProducts(DeleteTheirProducts value) {
        return new JAXBElement<DeleteTheirProducts>(_DeleteTheirProducts_QNAME, DeleteTheirProducts.class, null, value);
    }

}
