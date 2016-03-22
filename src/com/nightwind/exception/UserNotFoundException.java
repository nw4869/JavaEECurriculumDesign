package com.nightwind.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MSG = "User Not Found";

	/**
	 * Default Constructor
	 * @generated
	 */
	public UserNotFoundException() {
		super(DEFAULT_MSG);
	}

	/**
	 * Constructor taking message
	 * @generated
	 */
	public UserNotFoundException(String message) {
		super(message);
	}

	/**
	 * Constructor taking root cause
	 * @generated
	 */
	public UserNotFoundException(Throwable t) {
		super(t);
	}

	/**
	 * Constructor taking message and root cause
	 * @generated
	 */
	public UserNotFoundException(String message, Throwable t) {
		super(message, t);
	}

	public UserNotFoundException(Integer userId) {
		super(DEFAULT_MSG + ": userId=" + userId);
	}

}
