package com.heavyrent.custom_exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String mesg) {
		super(mesg);
	}
}
