package com.service.ratingservice.RatingService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.ratingservice.RatingService.entities.Rating;

public interface RatingDao extends JpaRepository<Rating,String> {

	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
}
