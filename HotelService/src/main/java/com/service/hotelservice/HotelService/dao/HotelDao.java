package com.service.hotelservice.HotelService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.hotelservice.HotelService.entities.Hotel;

public interface HotelDao extends JpaRepository<Hotel,String> {

}
