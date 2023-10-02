package com.service.hotelservice.HotelService.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Resouce not found on the server!!");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
