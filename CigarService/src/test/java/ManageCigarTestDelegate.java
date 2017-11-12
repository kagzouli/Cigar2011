import java.util.List;

import test.certif.entity.CategoryDb;
import test.certif.entity.CigarDb;
import test.certif.exception.BusinessException;
import test.certif.exception.TechnicalException;
import test.certif.service.client.ServiceLocator;
import test.certif.service.manageproduct.IManageCigar;


public class ManageCigarTestDelegate {
	
	private static final ManageCigarTestDelegate INSTANCE = new ManageCigarTestDelegate();

	private static final String JNDI_CIGAR_NAME = "ejb/manageCigar";

	private ManageCigarTestDelegate() {
		super();
	}

	public static ManageCigarTestDelegate getInstance() {
		return INSTANCE;
	}

	public List<CigarDb> searchCigarsByCategoryLabel(final String categoryLabel) throws BusinessException, TechnicalException {
		return getManageCigarRemote().searchCigarsByCategoryLabel(categoryLabel);
	}

	public CigarDb searchCigarById(Long idCigar) throws BusinessException, TechnicalException {
		return getManageCigarRemote().searchCigarById(idCigar);
	}

	Long storeCigar(CigarDb cigar) throws BusinessException, TechnicalException {
		return getManageCigarRemote().storeCigar(cigar);
	}

	void deleteCigar(Long idCigar) throws BusinessException, TechnicalException {
		getManageCigarRemote().deleteCigar(idCigar);
	}

	List<CategoryDb> findAllCategories() throws BusinessException, TechnicalException {
		return getManageCigarRemote().findAllCategories();
	}

	public IManageCigar getManageCigarRemote() {
		return (IManageCigar) ServiceTestLocator.getInstance().getRemoteInterface(JNDI_CIGAR_NAME);
	}


}
