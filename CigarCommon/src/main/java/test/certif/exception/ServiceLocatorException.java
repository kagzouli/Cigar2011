package test.certif.exception;

public class ServiceLocatorException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -26313263879126259L;

	public ServiceLocatorException(String message){
		super(message);
	}
	
	public ServiceLocatorException(Throwable exception){
		super(exception);
	}

}
