package com.blog.exception;

public class ArticleCatagoryInvalidException extends Exception{

	
	private static final long serialVersionUID = 1L;

	public ArticleCatagoryInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArticleCatagoryInvalidException(String message) {
		super(message);
	}

}
