package br.com.mgoficina.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Object not found: ";

	public ObjectNotFoundException(String msg) {
		super(msg+MESSAGE);
	}
}