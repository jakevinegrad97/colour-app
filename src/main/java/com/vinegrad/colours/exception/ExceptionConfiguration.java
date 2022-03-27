package com.vinegrad.colours.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class ExceptionConfiguration {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleExceptions(Exception exception, WebRequest webRequest) {
		var exceptionResponse = new ExceptionResponse("Failed to retrieve colour counts", exception.getMessage());
		return ResponseEntity.internalServerError().body(exceptionResponse);
	}
	

}
