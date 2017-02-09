package com.blog.exception;

public class UserInvalidException extends Exception{

	
	private static final long serialVersionUID = 1L;

	public UserInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserInvalidException(String message) {
		super(message);
	}

}
