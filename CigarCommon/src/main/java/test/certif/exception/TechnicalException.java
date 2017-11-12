package test.certif.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class TechnicalException extends Exception{
	
	private static final long serialVersionUID = 6666191337821678983L;

	public TechnicalException(String message){
		super(message);
	}
	
	public TechnicalException(Throwable exception){
		super(exception);
	}

}
