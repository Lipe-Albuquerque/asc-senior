package br.com.senior.ASC.main.services.exception;

public class DataIntregatyViolationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataIntregatyViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntregatyViolationException(String message) {
		super(message);
	}

	
	
}
