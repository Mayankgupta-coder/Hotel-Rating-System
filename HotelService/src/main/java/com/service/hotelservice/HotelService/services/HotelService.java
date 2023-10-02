package com.service.hotelservice.HotelService.services;

import java.util.List;

import com.service.hotelservice.HotelService.entities.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotels();
	
	Hotel getHotel(String HotelId);
}
