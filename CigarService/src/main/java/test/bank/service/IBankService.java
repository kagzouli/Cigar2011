
package test.bank.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3.3-hudson-757-SNAPSHOT
 * Generated source version: 2.1
 * 
 */
@WebService(name = "IBankService", targetNamespace = "http://service.bank.test/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IBankService {


    /**
     * 
     * @param creditCardType
     * @param creditCardNumber
     * @param expirationDate
     * @param firstName
     * @param lastName
     * @return
     *     returns test.bank.service.BankResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "creditCardPayment", targetNamespace = "http://service.bank.test/", className = "test.bank.service.CreditCardPayment")
    @ResponseWrapper(localName = "creditCardPaymentResponse", targetNamespace = "http://service.bank.test/", className = "test.bank.service.CreditCardPaymentResponse")
    public BankResponse creditCardPayment(
        @WebParam(name = "lastName", targetNamespace = "")
        String lastName,
        @WebParam(name = "firstName", targetNamespace = "")
        String firstName,
        @WebParam(name = "creditCardType", targetNamespace = "")
        String creditCardType,
        @WebParam(name = "creditCardNumber", targetNamespace = "")
        String creditCardNumber,
        @WebParam(name = "expirationDate", targetNamespace = "")
        String expirationDate);

}
