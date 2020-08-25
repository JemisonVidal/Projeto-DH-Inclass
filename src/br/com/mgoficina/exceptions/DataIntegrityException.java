package br.com.mgoficina.exceptions;

public class DataIntegrityException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Integrity failure on fields: ";
	
	public DataIntegrityException(String msg) {
		super(MESSAGE+ msg);
	}
}