package test.certif.service.client;

import java.util.List;

import test.certif.entity.Address;
import test.certif.entity.CigarOrderLine;
import test.certif.entity.CreditCard;
import test.certif.entity.Customer;
import test.certif.exception.PaymentNotAuthorisedException;
import test.certif.exception.TechnicalException;
import test.certif.service.managecart.IOrderService;

public class OrderDelegate implements IOrderService{	
	
	private static final long serialVersionUID = 5066758235647350292L;

	private static final OrderDelegate INSTANCE = new OrderDelegate();

	private static final String JNDI_ORDER_NAME = "ejb/orderbean";
		
	private OrderDelegate() {
		super();
	}

	public static OrderDelegate getInstance() {
		return INSTANCE;
	}


	public Long sendOrderToSystem(Customer customer, List<CigarOrderLine> listOrderCigarLine, CreditCard creditCard, String shippingCode) throws PaymentNotAuthorisedException,TechnicalException {
		return this.getOrderBeanRemote().sendOrderToSystem(customer, listOrderCigarLine, creditCard, shippingCode);
	}
	
	@Override
	public void sendRequestForShipping(String shippingCode, Address from, Address to, String reference) {
		this.getOrderBeanRemote().sendRequestForShipping(shippingCode, from, to, reference);
		
	}
	
	private IOrderService getOrderBeanRemote() {
		return (IOrderService) ServiceLocator.getInstance().getRemoteInterface(JNDI_ORDER_NAME);
	}

	
	
	

}
