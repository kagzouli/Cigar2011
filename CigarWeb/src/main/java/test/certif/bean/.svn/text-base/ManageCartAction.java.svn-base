package test.certif.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;


import test.certif.entity.CigarDb;
import test.certif.entity.CigarOrderLine;
import test.certif.entity.CreditCard;
import test.certif.entity.Customer;
import test.certif.exception.PaymentNotAuthorisedException;
import test.certif.exception.TechnicalException;
import test.certif.service.client.CustomerDelegate;
import test.certif.service.client.ManageCigarDelegate;
import test.certif.service.client.OrderDelegate;
import test.certif.service.managecart.IManageCart;

public class ManageCartAction extends AbstractAction{
	
	private HtmlDataTable dataTable;
	
	private Customer customer;
	
	private CreditCard creditCard;
	
	private String shippingCode;

	@EJB	
	private IManageCart manageCart;
	
	private Long idOrder;
	
	public ManageCartAction(){
		creditCard = new CreditCard();
		
		//TODO : Temporaire juste pour tester
		this.creditCard.setCreditCardNumber("122939423293293");
		this.creditCard.setExpirationDate("11/2011");
	}
	

	
	// private IManageCigar manageCigar;
	
	public List<CigarOrderLine> getListCartOrderLine(){ 
		return manageCart.getListCigarOrderLine();
		
	}
	
	public String addItemToCart(){
		Long idCigar = this.getParamId("cigarId");
		
		if (idCigar == null){
			throw new IllegalArgumentException("L'id cigar n'est pas renseigne");
		}
		
		try {
			
			int number = ManageCigarDelegate.getInstance().checkAvailability(idCigar);
			
			if (number == 0){
				this.addErrorMessage("This product is not still available");
				return null;
			}
			
		
	
			CigarDb cigar = ManageCigarDelegate.getInstance().searchCigarById(idCigar);
			manageCart.addCigar(cigar);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} 
		
		return "addItemToCart";
	}
	
	public String removeItemToCart(){
		Long idCigar = this.getParamId("cigarId");
		
		if (idCigar == null){
			throw new IllegalArgumentException("L'id cigar n'est pas renseigne");
		}
		
		try {
			CigarDb cigar = ManageCigarDelegate.getInstance().searchCigarById(idCigar);
			manageCart.removeCigar(cigar);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} 
		

		return null;
	}
	
	public Double getSubTotal(){
		try {
			return manageCart.getTotal();
		} catch (TechnicalException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Double getTotal(){
		Double total = this.getSubTotal();
		if (!StringUtils.isEmpty(this.shippingCode)){
			if ("FM".equals(this.shippingCode)){
				total = total + 3D;
			}else if ("IS".equals(this.shippingCode)){
				total = total + 5D;
			}
		}
		return total;
	}
	
	public Customer getCustomer() {
		FacesContext context = FacesContext.getCurrentInstance();
    	ExternalContext ec = context.getExternalContext();
    	final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
    	if ((request.getUserPrincipal()!= null) && (request.getUserPrincipal().getName() != null)){
    		String loginFind =  request.getUserPrincipal().getName();
    		customer = CustomerDelegate.getInstance().findCustomerByLogin(loginFind);
    	}
    		
		return customer;
	}
	
	public String sendOrder(){
		
		try {
			this.idOrder = OrderDelegate.getInstance().sendOrderToSystem(this.customer, this.getListCartOrderLine(),this.creditCard, this.shippingCode);
			System.out.println("Id order : "+this.idOrder);
			OrderDelegate.getInstance().sendRequestForShipping(this.shippingCode, this.customer.getAddress(), this.customer.getAddress(), this.idOrder.toString());
		}catch(PaymentNotAuthorisedException exception){
			this.addErrorMessage(exception.getMessage());
			return null;
		}
		catch (TechnicalException e) {
			this.addErrorMessage(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		return "ordersuccess";
	}
	
	
	public String modifyQuantity(){	
		return null;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}



	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}
	
	


}
