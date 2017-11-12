package test.certif.service.managecart;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import test.certif.entity.Address;
import test.certif.entity.CigarOrderLine;
import test.certif.entity.CreditCard;
import test.certif.entity.Customer;
import test.certif.exception.PaymentNotAuthorisedException;
import test.certif.exception.TechnicalException;

@Remote
public interface IOrderService extends Serializable{
	
	Long sendOrderToSystem(final Customer customer,final List<CigarOrderLine> listOrderCigarLine,CreditCard creditCard,String shippingCode) throws PaymentNotAuthorisedException,TechnicalException;

	void sendRequestForShipping(String shippingCode,Address from,Address to,final String reference);
}
