package com.vinegrad.colours.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ExceptionResponse {

	
	private ZonedDateTime timestamp;
	private String message;
	private String details;
	
	public ExceptionResponse(ZonedDateTime timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public ExceptionResponse(String message, String details) {
		this(ZonedDateTime.now(ZoneId.of("UTC")), message, details);
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
}
