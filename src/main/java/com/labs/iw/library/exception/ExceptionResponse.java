package com.labs.iw.library.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {


	private HttpStatus status;
	
	private String message;
	private LocalDate timeStamp;
	
	public ExceptionResponse() {
		
	}
	public ExceptionResponse(HttpStatus status, String message, LocalDate timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	
	public HttpStatus getStatus() {
		return status;
	}



	public void setStatus(HttpStatus status) {
		this.status = status;
	}



	public LocalDate getTimeStamp() {
		return timeStamp;
	}



	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
	
	
	
	
	
	
}
