package net.sahet.springtech.exception;

public class RequestValidationException extends RuntimeException {
	private static final long serialVersionUID = -8551300427268757457L;

	public RequestValidationException(String msg) {
		super(msg);
	}
}
