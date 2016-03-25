package com.nightwind.bbs.exception;

import java.lang.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @generated
 */
@ResponseStatus(value=HttpStatus.FORBIDDEN)
public class AuthorizeException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 * @generated
	 */
	public AuthorizeException() {
		super();
	}

	/**
	 * Constructor taking message
	 * @generated
	 */
	public AuthorizeException(String message) {
		super(message);
	}

	/**
	 * Constructor taking root cause
	 * @generated
	 */
	public AuthorizeException(Throwable t) {
		super(t);
	}

	/**
	 * Constructor taking message and root cause
	 * @generated
	 */
	public AuthorizeException(String message, Throwable t) {
		super(message, t);
	}

}
