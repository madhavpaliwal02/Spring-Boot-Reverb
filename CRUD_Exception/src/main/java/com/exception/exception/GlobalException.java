package com.exception.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorDetails> employeeException(EmployeeException ee, WebRequest req) {
		ErrorDetails error = new ErrorDetails(ee.getMessage(), req.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
