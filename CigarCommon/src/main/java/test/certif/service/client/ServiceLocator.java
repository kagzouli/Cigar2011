package test.certif.service.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import test.certif.exception.ServiceLocatorException;

public class ServiceLocator {

	private Context context;

	private Map<String, Object> cache;

	private static final ServiceLocator INSTANCE = new ServiceLocator();

	public static ServiceLocator getInstance() {
		return INSTANCE;
	}

	private ServiceLocator() throws ServiceLocatorException {
		try {	
			
			Properties props = new Properties();
			props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
			props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
			props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

			// optional. Defaults to localhost. Only needed if web server is
			// running
			// on a different host than the appserver
		//	props.setProperty("org.omg.CORBA.ORBInitialHost", "77.194.217.25");
	        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");

			props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

			context = new InitialContext(props);

			// Initialile le cache
			cache = new HashMap<String, Object>();

		} catch (Exception exception) {
			throw new ServiceLocatorException(exception);
		}
	}

	public Object getRemoteInterface(String jndiName) throws ServiceLocatorException {

		Object remoteInterface = cache.get(jndiName);

		if (remoteInterface == null) {
			try {
				remoteInterface = context.lookup(jndiName);
				cache.put(jndiName, remoteInterface);
			} catch (Exception exception) {
				throw new ServiceLocatorException(exception);
			}
		}

		return remoteInterface;

	}

}
