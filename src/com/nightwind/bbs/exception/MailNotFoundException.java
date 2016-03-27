package com.nightwind.bbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class MailNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6273993270111911480L;

	public MailNotFoundException() {
		super();
	}

	public MailNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MailNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MailNotFoundException(String message) {
		super(message);
	}

	public MailNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
