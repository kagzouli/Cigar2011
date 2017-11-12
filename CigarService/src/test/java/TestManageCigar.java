import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.sql.DataSource;

import org.apache.openjpa.persistence.OpenJPAEntityManager;
import org.apache.openjpa.persistence.OpenJPAPersistence;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test.certif.entity.CategoryDb;
import test.certif.entity.CigarDb;
import test.certif.service.manageproduct.IManageCigar;

public class TestManageCigar {


	private EntityManager entityManager;

	private static final File FILE_CREATE_DATABASE = new File("src/test/resources/createdatabase.sql");
	

	@Before
	public void beforeTest() throws Exception {

		try {
			File[] listSqlScript = { FILE_CREATE_DATABASE };
			// SQLUtils.executeSqlScript(listSqlScript);

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	 @Test
	public void testStoreCigar() {

		final String CIGAR_LABEL = "Cigar1";
		final String CIGAR_DESCRIPTION = "This is the new cigar. It is delicious";
		final BigDecimal AMOUNT = BigDecimal.valueOf(30.12);
		final String CATEGORY_LABEL = "Category3";

		CigarDb cigar = new CigarDb();
		cigar.setCigarLabel(CIGAR_LABEL);
		cigar.setDescription(CIGAR_DESCRIPTION);
		cigar.setLeftCigar(2);
		cigar.setCreationDate(new Date());
		cigar.setAmount(AMOUNT);

		CategoryDb category = new CategoryDb();
		category.setLabelCategory(CATEGORY_LABEL);
		category.setDescription("This is the new category");

		cigar.setCategory(category);

		try {
			ManageCigarTestDelegate.getInstance().storeCigar(cigar);

		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(false, true);
		}

	}

	
	// @Test
	public void testListCategories(){
		try {

			List<CategoryDb> listCategories = ManageCigarTestDelegate.getInstance().findAllCategories();
			assertNotNull(listCategories);
			System.out.println("Taille categories : "+ listCategories.size());
			
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(false, true);
		}
		
	}
	
//	@Test
	public void testDeleteCigar(){
		try {

			ManageCigarTestDelegate.getInstance().deleteCigar(3601L);
			
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(false, true);
		}
		
	}
	
  //  @Test
	public void testListCigar() {
		try {

			List<CigarDb> listCigar = ManageCigarTestDelegate.getInstance().searchCigarsByCategoryLabel("Category3");
			assertNotNull(listCigar);
			System.out.println("Taille cigare : "+ listCigar.size());
			
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(false, true);
		}

	}
	
	@Test
	public void testCigarById(){
		try {

			CigarDb cigar = ManageCigarTestDelegate.getInstance().searchCigarById(3551L);
			assertNotNull(cigar);
			System.out.println("Nom cigare : "+ cigar.getCigarLabel());
			System.out.println("Prix cigare : " + cigar.getAmount());
			System.out.println("Date cigare : "+ cigar.getCreationDate());
			System.out.println("Description : "+cigar.getDescription());
			System.out.println("Id cigare : "+cigar.getIdCigar());
			System.out.println("Nom categorie ; "+ cigar.getCategory().getLabelCategory());
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(false, true);
		}
		
	}


}
