package com.skumatov.palainteractive.rest.error;

public class GameDetailNotFoundException extends RuntimeException{

	public GameDetailNotFoundException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public GameDetailNotFoundException(String message) {
		super(message);
		
	}

	public GameDetailNotFoundException(Throwable cause) {
		super(cause);
	
	}

	
}
