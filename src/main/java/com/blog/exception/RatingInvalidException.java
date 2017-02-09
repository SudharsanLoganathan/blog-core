package com.blog.exception;

public class RatingInvalidException extends Exception{

	
	private static final long serialVersionUID = 1L;

	public RatingInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public RatingInvalidException(String message) {
		super(message);
	}

}
