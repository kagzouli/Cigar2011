package test.certif.dao.manageproduct;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import test.certif.entity.CategoryDb;
import test.certif.exception.DAOException;

@Local
public interface ICategoryDAO extends Serializable{
	
	
	/**
	 * Method to find all the categories.<br/>
	 * 
	 * @throws DAOException
	 */
	List<CategoryDb> findAll() throws DAOException;
	
	/**
	 * Load the category by id.<br/>
	 * 
	 * @param id
	 * @throws DAOException
	 */
	CategoryDb loadCategoryById(final Long id) throws DAOException;
	
	/**
	 * Creation.<br/>
	 * 
	 * @param category
	 * @return
	 * @throws DAOException
	 */
	Long create(CategoryDb category) throws DAOException;
	
	
	CategoryDb findByLabel(final String label);
	

}
