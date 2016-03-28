package com.nightwind.bbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TopicNotFoundException extends ResourceNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6273993270111911480L;

	public TopicNotFoundException() {
		super();
	}

	public TopicNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TopicNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TopicNotFoundException(String message) {
		super(message);
	}

	public TopicNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
