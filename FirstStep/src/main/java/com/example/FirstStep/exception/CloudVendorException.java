package com.example.FirstStep.exception;

import org.springframework.http.HttpStatus;

public class CloudVendorException {
	
	private final String Message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	
	public CloudVendorException(String message, Throwable throwable, HttpStatus httpStatus) {
		super();
		Message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}
	
	public String getMessage() {
		return Message;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
