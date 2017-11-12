

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.apache.openjpa.persistence.OpenJPAEntityManager;

public class SQLUtils {
    
    public static void executeSqlScript(final File[] listSqlScript) throws Exception{
        
        if ((listSqlScript != null) && (listSqlScript.length > 0)){
            Connection connection = null;
            PreparedStatement pStatement = null;
            try {
            	Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cigardb","root","root");
                
                for (File fileSqlScript : listSqlScript){
                    String sqlQuery = FileUtils.readFileToString(fileSqlScript);
                    pStatement = connection.prepareStatement(sqlQuery);
                    pStatement.executeUpdate(); 
                    pStatement.close();
                }
                
                connection.commit();
                
            } catch (Exception exception) {
                exception.printStackTrace();
                connection.rollback();
            } finally {
                if (pStatement != null){
                    pStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        }
       
        
    }

}
