package test.certif.service.client;

import java.util.List;

import test.certif.entity.CategoryDb;
import test.certif.entity.CigarDb;
import test.certif.exception.BusinessException;
import test.certif.exception.TechnicalException;
import test.certif.service.manageproduct.IManageCigar;

public class ManageCigarDelegate {
	
	private static final ManageCigarDelegate INSTANCE = new ManageCigarDelegate();

	private static final String JNDI_CIGAR_NAME = "ejb/manageCigar";

	private ManageCigarDelegate() {
		super();
	}

	public static ManageCigarDelegate getInstance() {
		return INSTANCE;
	}

	public List<CigarDb> searchCigarsByCategoryLabel(final String categoryLabel) throws BusinessException, TechnicalException {
		return getManageCigarRemote().searchCigarsByCategoryLabel(categoryLabel);
	}

	public CigarDb searchCigarById(Long idCigar) throws BusinessException, TechnicalException {
		return getManageCigarRemote().searchCigarById(idCigar);
	}

	public Long storeCigar(CigarDb cigar) throws BusinessException, TechnicalException {
		return getManageCigarRemote().storeCigar(cigar);
	}

	public void deleteCigar(Long idCigar) throws BusinessException, TechnicalException {
		getManageCigarRemote().deleteCigar(idCigar);
	}

	public List<CategoryDb> findAllCategories() throws BusinessException, TechnicalException {
		return getManageCigarRemote().findAllCategories();
	}
	
	public int checkAvailability(final Long idCigar) throws BusinessException,TechnicalException{
		return getManageCigarRemote().checkAvailability(idCigar);
	}


	private IManageCigar getManageCigarRemote() {
		return (IManageCigar) ServiceLocator.getInstance().getRemoteInterface(JNDI_CIGAR_NAME);
	}

}
