package com.service.userservice.UserService.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service.userservice.UserService.models.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("/hotel/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);
}
