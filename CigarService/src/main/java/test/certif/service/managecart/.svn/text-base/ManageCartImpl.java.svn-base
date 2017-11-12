package test.certif.service.managecart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import test.certif.entity.CigarDb;
import test.certif.entity.CigarOrderLine;
import test.certif.exception.TechnicalException;

@Stateful(name="ejb/manageCart",mappedName = "ejb/manageCart")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class ManageCartImpl implements IManageCart{
	
	private List<CigarOrderLine> listCigarOrderLine;
	
	@PostConstruct
	public void initialize(){
		this.listCigarOrderLine = new ArrayList<CigarOrderLine>();
	}
	
	@PreDestroy
	public void destroy(){
		this.listCigarOrderLine = null;
	}

	public void addCigar(CigarDb cigar) throws TechnicalException {
		
		if ((cigar == null) || (cigar.getIdCigar() == null)){
			throw new IllegalArgumentException("L'id du cigar doit etre renseigne");
		}
		
		if (this.listCigarOrderLine != null){
			boolean itemFound = false;
			for (CigarOrderLine cigarOrderLine : this.listCigarOrderLine){
				if (cigarOrderLine.getCigar().getIdCigar().equals(cigar.getIdCigar())){
					cigarOrderLine.setQuantity(cigarOrderLine.getQuantity() + 1);
					itemFound = true;
					break;
				}
			}
			
			if (!itemFound){
				listCigarOrderLine.add(new CigarOrderLine(cigar,1));
			}
		}
		
	}

	public void removeCigar(CigarDb cigar) throws TechnicalException {
		if ((cigar == null) || (cigar.getIdCigar() == null)){
			throw new IllegalArgumentException("L'id du cigar doit etre renseigne");
		}
		
		if (this.listCigarOrderLine != null){
			for (CigarOrderLine cigarOrderLine : this.listCigarOrderLine){
				if (cigarOrderLine.getCigar().getIdCigar().equals(cigar.getIdCigar())){
					listCigarOrderLine.remove(cigarOrderLine);
					break;
				}
			}	
		}
	
	}

	public Double getTotal() throws TechnicalException {

		BigDecimal total = BigDecimal.valueOf(0);
		if (this.listCigarOrderLine != null){
			for (CigarOrderLine cigarOrderLine : this.listCigarOrderLine){
				total = total.add(cigarOrderLine.getSubTotal());
			}
		}
		
		return total.doubleValue();
	}

	public void clear() throws TechnicalException {
		this.listCigarOrderLine.clear();
	}

	public void setListCigarOrderLine(List<CigarOrderLine> listCigarOrderLine) throws TechnicalException {
		this.listCigarOrderLine = listCigarOrderLine;
	}

	public List<CigarOrderLine> getListCigarOrderLine() {
		return listCigarOrderLine;
	}
	
	

}
