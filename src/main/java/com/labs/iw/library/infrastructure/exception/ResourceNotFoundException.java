package com.labs.iw.library.infrastructure.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super();
	}

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	
	public ResourceNotFoundException(String message) {
		super(message);
	
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}


	
	

	
	
}
