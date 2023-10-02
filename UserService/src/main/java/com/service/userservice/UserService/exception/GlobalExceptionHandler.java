package com.service.userservice.UserService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.service.userservice.UserService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception) {
		String message=exception.getMessage();
		HttpStatus httpStatus=HttpStatus.NOT_FOUND;
		boolean success=true;
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(message,success,httpStatus));
	}
}
