package test.certif.service.manageproduct;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import test.certif.entity.CategoryDb;
import test.certif.entity.CigarDb;
import test.certif.exception.BusinessException;
import test.certif.exception.TechnicalException;

@Remote
public interface IManageCigar extends Serializable{
	
	/**
	 * Method to search cigar using the category label.<br/>
	 * 
	 * @param categoryLabel
	 * @throws BusinessException
	 * @throws TechnicalException
	 */
	List<CigarDb> searchCigarsByCategoryLabel(final String categoryLabel) throws BusinessException,TechnicalException;

	/**
	 * Method to search cigar using the cigar id.<br/>
	 * 
	 * @param idCigar
	 * @return
	 * @throws BusinessException
	 * @throws TechnicalException
	 */
	CigarDb searchCigarById(Long idCigar) throws BusinessException,TechnicalException; 

	/**
	 * Method to create cigar.<br/>
	 * 
	 * @param cigar
	 * @return
	 * @throws BusinessException
	 * @throws TechnicalException
	 */
	 Long storeCigar(CigarDb cigar) throws BusinessException,TechnicalException;


	/**
	 * Method to delete cigar using the id.<br/>
	 * 
	 * @param idCigar
	 * @throws BusinessException
	 * @throws TechnicalException
	 */
	 void deleteCigar(Long idCigar) throws BusinessException,TechnicalException;
	
	 List<CategoryDb> findAllCategories() throws BusinessException,TechnicalException;
	 
	 int checkAvailability(final Long idCigar) throws BusinessException,TechnicalException;
	 
}
