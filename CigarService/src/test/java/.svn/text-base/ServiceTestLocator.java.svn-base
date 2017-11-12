

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import test.certif.exception.ServiceLocatorException;

public class ServiceTestLocator {
	
private Context context;
	
	private Map<String,Object> cache;
	
	private static final ServiceTestLocator INSTANCE = new ServiceTestLocator();
	
	public static ServiceTestLocator getInstance(){
		return INSTANCE;
	}
	
	private ServiceTestLocator() throws ServiceLocatorException{
		try{
			Properties properties = new Properties();
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
			properties.setProperty("openejb.deployments.classpath.include", ".*");
			properties.put("jdbc/cigarDb", "new://Resource?type=DataSource");

			properties.put("jdbc/cigarDb.JdbcDriver", "com.mysql.jdbc.Driver");
			properties.put("jdbc/cigarDb.JdbcUrl", "jdbc:mysql://localhost:3306/cigardb");
			properties.put("jdbc/cigarDb.UserName", "root");
			properties.put("jdbc/cigarDb.Password", "root");

			properties.put("jdbc/cigarDb.JtaManaged", "false");

			context = new InitialContext(properties);


			// Initialile le cache
			cache = new HashMap<String,Object>();
			
		}catch(Exception exception){
			throw new ServiceLocatorException(exception);
		}
	}
	
	public Object getRemoteInterface(final String jndiName) throws ServiceLocatorException{
		
		
		Object remoteInterface = cache.get(jndiName);
		
		if (remoteInterface == null){
			try{
				remoteInterface = context.lookup(jndiName);
				cache.put(jndiName, remoteInterface);				
			}catch(Exception exception){
				throw new ServiceLocatorException(exception);
			}
		}
		
		return remoteInterface;
		
	}


}
