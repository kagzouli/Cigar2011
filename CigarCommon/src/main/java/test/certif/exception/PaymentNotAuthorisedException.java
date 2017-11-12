package test.certif.exception;

public class PaymentNotAuthorisedException extends BusinessException{

	private static final long serialVersionUID = -1399483660538820068L;
	
	public PaymentNotAuthorisedException(String message){
		super(message);
	}
	
	public PaymentNotAuthorisedException(Throwable exception){
		super(exception);
	}
	
	

}
