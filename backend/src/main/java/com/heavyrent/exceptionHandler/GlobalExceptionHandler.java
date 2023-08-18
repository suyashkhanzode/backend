package com.heavyrent.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.heavyrent.custom_exception.ResourceNotFoundException;
import com.heavyrent.custom_exception.WishlistException;
import com.heavyrent.dto.LoginErrorResponse;



@RestControllerAdvice 
public class GlobalExceptionHandler {
	
	@ExceptionHandler(WishlistException.class)
	public ResponseEntity<String> handleWishlistException(WishlistException ex) {
//		String message=ex.getMessage();
//		message="invalid id";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

		
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<LoginErrorResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException e) {
		System.out.println("method arg invalid " + e);
		String message =e.getMessage();
		LoginErrorResponse apiResponse=new LoginErrorResponse(message,false);
		return new ResponseEntity<LoginErrorResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
}
