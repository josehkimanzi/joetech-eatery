package com.joetech.eatery.exception;

public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4445255614269210935L;

	public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
