package com.hcl.ecommerce.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String errorMessage;

	public UserNotFoundException(String errorMessage) {

		super(errorMessage);

	}


	
}
