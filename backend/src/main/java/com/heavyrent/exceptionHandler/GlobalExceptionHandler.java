package com.heavyrent.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.heavyrent.custom_exception.ResourceNotFoundException;
import com.heavyrent.custom_exception.WishlistException;
import com.heavyrent.dto.ErrorResponse;


@RestControllerAdvice 
public class GlobalExceptionHandler {
	
	@ExceptionHandler(WishlistException.class)
	public ResponseEntity<String> handleWishlistException(WishlistException ex) {
//		String message=ex.getMessage();
//		message="invalid id";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
	
	
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException e) {
		System.out.println("method arg invalid " + e);
		String message =e.getMessage();
		ErrorResponse apiResponse=new ErrorResponse(message,false);
		return new ResponseEntity<ErrorResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
}
