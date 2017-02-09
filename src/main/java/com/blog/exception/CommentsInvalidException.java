package com.blog.exception;

public class CommentsInvalidException extends Exception{


	private static final long serialVersionUID = 1L;

	public CommentsInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommentsInvalidException(String message) {
		super(message);
	}

}
