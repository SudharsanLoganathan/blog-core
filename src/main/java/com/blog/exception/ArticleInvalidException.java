package com.blog.exception;

public class ArticleInvalidException extends Exception{

	
	private static final long serialVersionUID = 1L;

	public ArticleInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArticleInvalidException(String message) {
		super(message);
	}

}
