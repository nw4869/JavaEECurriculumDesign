package com.nightwind.bbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ForumNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6273993270111911480L;

	public ForumNotFoundException() {
		super();
	}

	public ForumNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ForumNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ForumNotFoundException(String message) {
		super(message);
	}

	public ForumNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
