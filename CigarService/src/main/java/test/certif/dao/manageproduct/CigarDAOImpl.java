package test.certif.dao.manageproduct;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import test.certif.entity.CigarDb;
import test.certif.exception.DAOException;

@Stateless(name="ejb/cigarDAO",mappedName="ejb/cigarDAO")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
public class CigarDAOImpl implements ICigarDAO {

	/** The logger of this class. **/
	private static final Logger LOGGER = Logger.getLogger(CigarDAOImpl.class.getName());

	
	@PersistenceContext(name="CigarUnit",unitName="CigarUnit")
	private EntityManager entityManager;

	public Long create(CigarDb cigar) throws DAOException {
		try {
			entityManager.persist(cigar);
			return cigar.getIdCigar();
		} catch (Exception exception) {
			throw new DAOException(exception);
		}
	}

	public void update(CigarDb cigar) throws DAOException {
		try {
			entityManager.persist(cigar);
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE, exception.getMessage());
			throw new DAOException(exception);
		}

	}

	public void delete(Long idCigar) throws DAOException {
		try{
			CigarDb cigar = entityManager.find(CigarDb.class, idCigar);
			entityManager.remove(cigar);
		}catch(Exception exception){
			LOGGER.log(Level.SEVERE, exception.getMessage());
			throw new DAOException(exception);
		}
	}

	public CigarDb loadCigarById(Long idCigar) throws DAOException {
		try{
			return entityManager.find(CigarDb.class, idCigar);
		}
		catch(Exception exception){
			LOGGER.log(Level.SEVERE, exception.getMessage());
			throw new DAOException(exception);
		}
	}

	public List<CigarDb> searchCigarsByLabelCategory(String labelCategory) throws DAOException {
		try{
			Query query = entityManager.createQuery("SELECT c FROM CigarDb c where c.category.labelCategory= :label");
			query.setParameter("label",labelCategory);
			return (List<CigarDb> ) query.getResultList();
		}
		
		catch(Exception exception){
			LOGGER.log(Level.SEVERE, exception.getMessage());
			throw new DAOException(exception);
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	

}
