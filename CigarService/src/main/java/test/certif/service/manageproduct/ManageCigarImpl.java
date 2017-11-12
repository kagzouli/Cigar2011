package test.certif.service.manageproduct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;

import test.certif.dao.manageproduct.ICategoryDAO;
import test.certif.dao.manageproduct.ICigarDAO;
import test.certif.entity.CategoryDb;
import test.certif.entity.CigarDb;
import test.certif.exception.BusinessException;
import test.certif.exception.DAOException;
import test.certif.exception.TechnicalException;

/**
 * Implementation to manage the cigar parameters.
 * 
 * @author Karim
 *
 */

@Stateless(name="ejb/manageCigar",mappedName = "ejb/manageCigar")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class ManageCigarImpl implements IManageCigar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4218256746562639564L;

	@EJB(name="ejb/categorieDAO",beanName="ejb/categorieDAO",mappedName="ejb/categorieDAO")
	private ICategoryDAO categoryDAO;

	@EJB(name="ejb/cigarDAO",beanName="ejb/cigarDAO",mappedName="ejb/cigarDAO")
	private ICigarDAO cigarDAO;

	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<CigarDb> searchCigarsByCategoryLabel(String categoryLabel) throws BusinessException, TechnicalException {
		try {
			List<CigarDb> listCigarDb = cigarDAO.searchCigarsByLabelCategory(categoryLabel);
			return listCigarDb;
		} catch (DAOException exception) {
			throw new TechnicalException(exception);
		}
	}

	public CigarDb searchCigarById(Long idCigar) throws BusinessException, TechnicalException {
		try {
			CigarDb cigarDb = cigarDAO.loadCigarById(idCigar);
			return cigarDb;
		} catch (DAOException exception) {
			throw new TechnicalException(exception);
		}
	}

	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public Long storeCigar(CigarDb cigar) throws BusinessException, TechnicalException {
		try {
			// Pas propre mais c du test
			CategoryDb category = cigar.getCategory();

			CategoryDb categoryLoad = categoryDAO.findByLabel(category.getLabelCategory());
			if (categoryLoad != null) {
				cigar.setCategory(categoryLoad);
			}

			Long value = cigarDAO.create(cigar);
			return value;
		} catch (Exception exception) {
			throw new TechnicalException(exception);
		}
	}

	public void deleteCigar(Long idCigar) throws BusinessException, TechnicalException {
		try {
			cigarDAO.delete(idCigar);
		} catch (DAOException exception) {
			throw new TechnicalException(exception);
		}
	}

	public List<CategoryDb> findAllCategories() throws BusinessException, TechnicalException {
		try {
			List<CategoryDb> listCategoryDb = categoryDAO.findAll();

			return listCategoryDb;

		} catch (DAOException exception) {
			throw new TechnicalException(exception);
		}
	}
	
	public int checkAvailability(final Long idCigar) throws BusinessException,TechnicalException{
		CigarDb cigar = this.searchCigarById(idCigar);
		return (cigar == null) ? 0 : cigar.getLeftCigar();
	}

}
