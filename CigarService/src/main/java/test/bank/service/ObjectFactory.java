
package test.bank.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the test.bank.service package. 
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

    private final static QName _CreditCardPaymentResponse_QNAME = new QName("http://service.bank.test/", "creditCardPaymentResponse");
    private final static QName _CreditCardPayment_QNAME = new QName("http://service.bank.test/", "creditCardPayment");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: test.bank.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreditCardPaymentResponse }
     * 
     */
    public CreditCardPaymentResponse createCreditCardPaymentResponse() {
        return new CreditCardPaymentResponse();
    }

    /**
     * Create an instance of {@link BankResponse }
     * 
     */
    public BankResponse createBankResponse() {
        return new BankResponse();
    }

    /**
     * Create an instance of {@link CreditCardPayment }
     * 
     */
    public CreditCardPayment createCreditCardPayment() {
        return new CreditCardPayment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditCardPaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bank.test/", name = "creditCardPaymentResponse")
    public JAXBElement<CreditCardPaymentResponse> createCreditCardPaymentResponse(CreditCardPaymentResponse value) {
        return new JAXBElement<CreditCardPaymentResponse>(_CreditCardPaymentResponse_QNAME, CreditCardPaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditCardPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bank.test/", name = "creditCardPayment")
    public JAXBElement<CreditCardPayment> createCreditCardPayment(CreditCardPayment value) {
        return new JAXBElement<CreditCardPayment>(_CreditCardPayment_QNAME, CreditCardPayment.class, null, value);
    }

}
