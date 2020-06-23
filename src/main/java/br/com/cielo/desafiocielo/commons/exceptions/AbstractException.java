package br.com.cielo.desafiocielo.commons.exceptions;

public abstract class AbstractException extends RuntimeException {
	private static final long serialVersionUID = -6180041068399659221L;
	
	public AbstractException(final String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public AbstractException(String message) {
		super(message);
	}
	
	
	public AbstractException(Throwable throwable) {
		super(throwable);
	}
}
