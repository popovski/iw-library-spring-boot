package com.library.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), LocalDate.now());
		
//		exceptionResponse.setStatus(status.BAD_REQUEST);
//		exceptionResponse.setMessage(ex.getMessage());
//		exceptionResponse.setTimeStamp(exceptionResponse.getTimestamp());
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);		
	}
	
	
	@ExceptionHandler(value = NotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException nfe, WebRequest request){
		
		String errorMessageDescription = nfe.getLocalizedMessage();
		
		if(errorMessageDescription == null) errorMessageDescription = nfe.getLocalizedMessage().toString();

		ExceptionResponse exceptionResponse = new ExceptionResponse (HttpStatus.NOT_FOUND, errorMessageDescription, LocalDate.now());
		
//		exceptionResponse.setStatus(status.NOT_FOUND);
//		exceptionResponse.setMessage(nfe.getMessage());
//		exceptionResponse.setTimeStamp(exceptionResponse.getTimestamp());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
