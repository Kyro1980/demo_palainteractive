package com.skumatov.palainteractive.rest.error;

public class EntityDetailNotFoundException extends RuntimeException{

	public EntityDetailNotFoundException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public EntityDetailNotFoundException(String message) {
		super(message);
		
	}

	public EntityDetailNotFoundException(Throwable cause) {
		super(cause);
	
	}

	
}
