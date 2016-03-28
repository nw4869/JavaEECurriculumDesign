package com.nightwind.bbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MailReciverValidateException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MSG = "User Not Found";

	/**
	 * Default Constructor
	 * @generated
	 */
	public MailReciverValidateException() {
		super(DEFAULT_MSG);
	}

	/**
	 * Constructor taking message
	 * @generated
	 */
	public MailReciverValidateException(String message) {
		super(message);
	}

	/**
	 * Constructor taking root cause
	 * @generated
	 */
	public MailReciverValidateException(Throwable t) {
		super(t);
	}

	/**
	 * Constructor taking message and root cause
	 * @generated
	 */
	public MailReciverValidateException(String message, Throwable t) {
		super(message, t);
	}

	public MailReciverValidateException(Integer userId) {
		super(DEFAULT_MSG + ": userId=" + userId);
	}

}
