package net.sahet.springtech.exception;

public class RateNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8551300427268757457L;

	public RateNotFoundException(String msg) {
		super(msg);
	}
}
