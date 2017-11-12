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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import test.certif.entity.CategoryDb;
import test.certif.exception.DAOException;

@Stateless(name="ejb/categorieDAO",mappedName="ejb/categorieDAO")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
public class CategoryDAOImpl implements ICategoryDAO {

	/** The logger of this class. **/
	private static final Logger LOGGER = Logger.getLogger(CigarDAOImpl.class.getName());

	@PersistenceContext(name="CigarUnit",unitName="CigarUnit")
	private EntityManager entityManager;

	public List<CategoryDb> findAll() throws DAOException {
		try {
			Query query = entityManager.createQuery("SELECT c FROM CategoryDb c order by c.labelCategory asc");
			return (List<CategoryDb>) query.getResultList();
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE, exception.getMessage());
			throw new DAOException(exception);
		}

	}

	public CategoryDb loadCategoryById(Long id) throws DAOException {
		try{
			return entityManager.find(CategoryDb.class, id);
		}catch(Exception exception){
			LOGGER.log(Level.SEVERE, exception.getMessage());
			throw new DAOException(exception);
		}

	}

	public Long create(CategoryDb category) throws DAOException {
		try{
		   entityManager.persist(category);
		   entityManager.refresh(category);
		   return category.getIdCategory();
		}catch(Exception exception){
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

	public CategoryDb findByLabel(String label) {
		try{
			Query query = entityManager.createQuery("SELECT c FROM CategoryDb c WHERE c.labelCategory = :label");
			query.setParameter("label",label);
			return (CategoryDb) query.getSingleResult();
		}catch(NoResultException exception){
			return null;
		}
	}
	
	

}
