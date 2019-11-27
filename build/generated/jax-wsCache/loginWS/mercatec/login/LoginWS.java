
package mercatec.login;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "loginWS", targetNamespace = "http://login.mercatec/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LoginWS {


    /**
     * 
     * @param pass
     * @param nombre
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://login.mercatec/", className = "mercatec.login.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://login.mercatec/", className = "mercatec.login.LoginResponse")
    @Action(input = "http://login.mercatec/loginWS/loginRequest", output = "http://login.mercatec/loginWS/loginResponse")
    public int login(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "pass", targetNamespace = "")
        String pass);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "userType", targetNamespace = "http://login.mercatec/", className = "mercatec.login.UserType")
    @ResponseWrapper(localName = "userTypeResponse", targetNamespace = "http://login.mercatec/", className = "mercatec.login.UserTypeResponse")
    @Action(input = "http://login.mercatec/loginWS/userTypeRequest", output = "http://login.mercatec/loginWS/userTypeResponse")
    public String userType();

}
