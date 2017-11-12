package test.certif.service.client;

import java.util.List;

import test.certif.entity.CigarDb;
import test.certif.entity.CigarOrderLine;
import test.certif.exception.TechnicalException;
import test.certif.service.managecart.IManageCart;

public class ManageCartDelegate{
	
	private static final ManageCartDelegate INSTANCE = new ManageCartDelegate();
	
	private static final String JNDI_CART_NAME = "ejb/manageCart";

	private ManageCartDelegate() {
		super();
	}

	public static ManageCartDelegate getInstance() {
		return INSTANCE;
	}

	public void addCigar(CigarDb cigar) throws TechnicalException {
		this.getManageCartRemote().addCigar(cigar);
		
	}

	public void removeCigar(CigarDb cigar) throws TechnicalException {
		this.getManageCartRemote().removeCigar(cigar);
		
	}

	public Double getTotal() throws TechnicalException {
		return this.getManageCartRemote().getTotal();
	}

	public void clear() throws TechnicalException {
		this.getManageCartRemote().clear();
		
	}

	public void setListCigarOrderLine(List<CigarOrderLine> listCigarOrderLine) throws TechnicalException {
		this.getManageCartRemote().setListCigarOrderLine(listCigarOrderLine);
		
	}

	public List<CigarOrderLine> getListCigarOrderLine() {
		return this.getManageCartRemote().getListCigarOrderLine();
	}
	
	private IManageCart getManageCartRemote() {
		return (IManageCart) ServiceLocator.getInstance().getRemoteInterface(JNDI_CART_NAME);
	}

}
