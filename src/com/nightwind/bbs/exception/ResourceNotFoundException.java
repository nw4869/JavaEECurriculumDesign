package com.nightwind.bbs.exception;

import java.lang.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 * @generated
	 */
	public ResourceNotFoundException() {
		super();
	}

	/**
	 * Constructor taking message
	 * @generated
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

	/**
	 * Constructor taking root cause
	 * @generated
	 */
	public ResourceNotFoundException(Throwable t) {
		super(t);
	}

	/**
	 * Constructor taking message and root cause
	 * @generated
	 */
	public ResourceNotFoundException(String message, Throwable t) {
		super(message, t);
	}

	public ResourceNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
