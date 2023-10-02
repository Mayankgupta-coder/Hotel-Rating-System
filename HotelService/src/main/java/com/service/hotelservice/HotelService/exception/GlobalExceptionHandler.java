package com.service.hotelservice.HotelService.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>>handlerResourceNotFoundException(ResourceNotFoundException exception) {
		Map<String,Object>ApiResponse=new HashMap<>();
		ApiResponse.put("Message",exception.getMessage());
		ApiResponse.put("Success", false);
		ApiResponse.put("Status",HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse);
	}
}
