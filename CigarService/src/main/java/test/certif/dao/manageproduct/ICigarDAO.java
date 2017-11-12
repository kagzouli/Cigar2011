package test.certif.dao.manageproduct;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import test.certif.entity.CigarDb;
import test.certif.exception.DAOException;

@Local
public interface ICigarDAO extends Serializable {
	
	
	/**
	 * Store the CigarDb in the warehouse.<br/>
	 * 
	 * @param cigar
	 * @return
	 * @throws DAOException
	 */
     Long create(final CigarDb cigar) throws DAOException;
     
     /**
      * 
      * Update the cigar from the warehouse.<br/>
      * @param cigar
      * @throws DAOException
      */
     void update(final CigarDb cigar) throws DAOException;
     
     /**
      * Delete the cigar.<br/>
      * 
      * @param idCigar
      * @throws DAOException
      */
     void delete(final Long idCigar) throws DAOException;
     
     
     /**
      * Load cigar by id.<br/>
      * 
      * @param idCigar
      * @throws DAOException
      */
     CigarDb loadCigarById(final Long idCigar) throws DAOException;
     
     /**
      * Search the cigar by label category.<br/>
      * 
      * @param labelCategory
      * @throws DAOException
      */
     List<CigarDb> searchCigarsByLabelCategory(final String labelCategory) throws DAOException;

}
