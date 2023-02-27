package com.labs.iw.library.infrastructure.exception.controlleradvice;

import java.util.Date;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.labs.iw.library.infrastructure.exception.ResourceNotFoundException;
import com.labs.iw.library.infrastructure.exception.pojo.ExceptionResponse;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		var errors = new HashMap<>();
		for (var err : ex.getBindingResult().getAllErrors())
			errors.put(((FieldError) err).getField(), err.getDefaultMessage());


		return this.handleExceptionInternal(ex, errors, headers, status, request);
	}
	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();

		exceptionResponse.setStatus(HttpStatus.BAD_REQUEST);
		exceptionResponse.setMessage(ex.getLocalizedMessage());
		exceptionResponse.setTimestamp(new Date());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(ResourceNotFoundException nfe, WebRequest request) {

		String errorMessageDescription = nfe.getLocalizedMessage();

		if (errorMessageDescription == null)
			errorMessageDescription = nfe.getMessage();

		ExceptionResponse exceptionResponse = new ExceptionResponse();

		exceptionResponse.setStatus(HttpStatus.NOT_FOUND);
		exceptionResponse.setMessage(errorMessageDescription);
		exceptionResponse.setTimestamp(new Date());
		exceptionResponse.setErrorCode("L-001");
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}