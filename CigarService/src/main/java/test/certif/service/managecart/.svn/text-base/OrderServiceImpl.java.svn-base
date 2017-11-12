package test.certif.service.managecart;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import org.apache.commons.lang.StringUtils;

import test.bank.service.BankResponse;
import test.bank.service.BankServiceImplService;
import test.bank.service.IBankService;
import test.certif.entity.Address;
import test.certif.entity.CigarOrderLine;
import test.certif.entity.CreditCard;
import test.certif.entity.Customer;
import test.certif.entity.Order;
import test.certif.exception.PaymentNotAuthorisedException;
import test.certif.exception.TechnicalException;
import test.shipping.service.FactoryShippingService;
import test.shipping.service.IShippingService;

@Stateless(name="ejb/orderbean",mappedName = "ejb/orderbean")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class OrderServiceImpl implements IOrderService{

	private static final long serialVersionUID = 5182212592024951015L;
	
	@WebServiceRef
	private BankServiceImplService bankService;
	
	@Resource(mappedName="jms/cigarstoreConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	private Connection connectionJms;
	
	@Resource(mappedName="jms/topic/order")
	private Topic topicOrder;
	
	@PersistenceContext(name="CigarUnit",unitName="CigarUnit")
	private EntityManager entityManager;

	
	@PostConstruct
	public void initialize(){
		try{
			connectionJms = connectionFactory.createConnection();
		}catch(JMSException exception){
			throw new EJBException(exception);
		}
		
	}
	
	@PreDestroy
	public void close(){
		if (connectionJms != null){
			try {
				connectionJms.close();
			} catch (JMSException e) {
				throw new EJBException(e);
			}
		}
	}

	public Long sendOrderToSystem(Customer customer, List<CigarOrderLine> listOrderCigarLine, CreditCard creditCard, String shippingCode) throws PaymentNotAuthorisedException,TechnicalException {
		Order order = new Order();
		order.setListCigarOrder(listOrderCigarLine);
		order.setCustomer(customer);
		order.setCreditCard(creditCard);
		
		Double totalAmount = 0D;
		if (listOrderCigarLine != null){
			for (CigarOrderLine cigarOrderLine : listOrderCigarLine){
				System.out.println("Cigar Order Line : " + cigarOrderLine.getCigar().getCigarLabel());
				totalAmount = totalAmount + cigarOrderLine.getSubTotal().doubleValue();
			}
			
			if (!StringUtils.isEmpty(shippingCode)){
				if (FactoryShippingService.FREIGHT_MOVERS_CODE.equals(shippingCode)){
					totalAmount = totalAmount + 3D;
				}else if (FactoryShippingService.INTERNAT_SHIPPING.equals(shippingCode)){
					totalAmount = totalAmount + 5D;
				}
			}
		}
		order.setTotalAmount(BigDecimal.valueOf(totalAmount));
		
		// Test autorisation credit card payment.
		IBankService bank = bankService.getBankServiceImplPort();
		BankResponse response = bank.creditCardPayment(customer.getPrenom(), customer.getNom(), creditCard.getCreditCardType(), creditCard.getCreditCardNumber(), creditCard.getExpirationDate());
		
		if (!response.getResponse().equals("SUCESSFUL")){
			throw new PaymentNotAuthorisedException(response.getCause());
		}
		
		// Set the CigarOrderLine table
		if (listOrderCigarLine != null){
			for (CigarOrderLine cigarOrderLine : listOrderCigarLine){
				cigarOrderLine.setOrder(order);
			}
		}

		// Store the order
		entityManager.persist(order);
		entityManager.flush();
		
		// Send email confirmation
		publishOrder(order);
		
		// Respond with an order
		
		System.out.println("Id order : "+order.getIdOrder());
		return order.getIdOrder();				
	}
	
	@Override
	public void sendRequestForShipping(String shippingCode,Address from, Address to, String reference) {
		//Shipping request to the selected shipping company
		IShippingService shippingService = FactoryShippingService.getInstance().createShippingService(shippingCode);
		shippingService.sendShippingRequest(from, to,reference);
	}
	
	private void publishOrder(final Order order){
		
		if (order == null){
			throw new IllegalArgumentException("The order can't be null.");
		}
		
		Session sessionJms = null;
		
		try{
			sessionJms = connectionJms.createSession(true, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = sessionJms.createProducer(topicOrder);
			
			ObjectMessage objectMessage = sessionJms.createObjectMessage();
			objectMessage.setObject(order);
			
			producer.send(objectMessage);
			
		}catch(JMSException exception){
			throw new EJBException(exception);
		}finally{
			if (sessionJms != null){
				try {
					sessionJms.close();
				} catch (JMSException e) {
					e.printStackTrace();
					throw new EJBException(e);
				}
			}
		}
		
		
	}



}
