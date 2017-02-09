package com.blog.exception;

public class RoleInvalidException extends Exception{

	
	private static final long serialVersionUID = 1L;

	public RoleInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoleInvalidException(String message) {
		super(message);
	}

}
