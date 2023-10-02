package com.service.hotelservice.HotelService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hotelservice.HotelService.dao.HotelDao;
import com.service.hotelservice.HotelService.entities.Hotel;
import com.service.hotelservice.HotelService.exception.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelDao hotelDao;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String id=UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelDao.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelDao.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		// TODO Auto-generated method stub
		return hotelDao.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel with given id " + hotelId + " not found"));
	}

}
