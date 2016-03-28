package com.nightwind.bbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ReplyNotFoundException extends ResourceNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6273993270111911480L;

	public ReplyNotFoundException() {
		super();
	}

	public ReplyNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ReplyNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReplyNotFoundException(String message) {
		super(message);
	}

	public ReplyNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
