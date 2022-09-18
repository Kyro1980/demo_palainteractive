package com.skumatov.palainteractive.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityRestExceptionHandler {
	
	//exception handler
	@ExceptionHandler
	public ResponseEntity<EntityErrorResponse> handleException(EntityDetailNotFoundException exc){
		EntityErrorResponse err = new EntityErrorResponse();
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(exc.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<EntityErrorResponse> handleException(Exception exc){
		EntityErrorResponse err = new EntityErrorResponse();
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(exc.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		
	}

}
