package test.certif.service.managecart;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import test.certif.entity.CigarDb;
import test.certif.entity.CigarOrderLine;
import test.certif.exception.TechnicalException;

@Local
public interface IManageCart {
	
	
	void addCigar(CigarDb cigar) throws TechnicalException;
	
	void removeCigar(CigarDb cigar) throws TechnicalException;
	
	Double getTotal() throws TechnicalException;
	
	void clear() throws TechnicalException;
	
	void setListCigarOrderLine(List<CigarOrderLine> listCigarOrderLine) throws TechnicalException;
	
    List<CigarOrderLine> getListCigarOrderLine();

}
