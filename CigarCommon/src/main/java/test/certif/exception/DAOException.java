package test.certif.exception;

public class DAOException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1339499494343043340L;

	public DAOException(String message){
		super(message);
	}
	
	public DAOException(Throwable exception){
		super(exception);
	}
}
