package test.certif.service.manageproduct;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.certif.entity.Customer;

@Stateless(name="ejb/customerbean",mappedName = "ejb/customerbean")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)

public class CustomerBeanImpl implements ICustomerService{

	private static final long serialVersionUID = 61356043890141669L;

	@PersistenceContext(name="CigarUnit",unitName="CigarUnit")
	private EntityManager entityManager;

	
	public Customer findCustomerByLogin(String login) {
		return entityManager.find(Customer.class, login);
	}
	
	

}
