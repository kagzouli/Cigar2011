package test.certif.service.client;

import test.certif.entity.Customer;
import test.certif.service.manageproduct.ICustomerService;

public class CustomerDelegate{
	
	private static final CustomerDelegate INSTANCE = new CustomerDelegate();
	
	private static final String JNDI_CUSTOMER_NAME = "ejb/customerbean";

	private CustomerDelegate() {
		super();
	}

	public static CustomerDelegate getInstance() {
		return INSTANCE;
	}


	public Customer findCustomerByLogin(String login) {
		return this.getCustomerServiceRemote().findCustomerByLogin(login);
	}
	
	private ICustomerService getCustomerServiceRemote() {
		return (ICustomerService) ServiceLocator.getInstance().getRemoteInterface(JNDI_CUSTOMER_NAME);
	}

}
