package com.service.ratingservice.RatingService.services;

import java.util.List;

import com.service.ratingservice.RatingService.entities.Rating;

public interface RatingService {

	Rating createRating(Rating rating);
	List<Rating> getAllRatings();
	List<Rating> getAllRatingByUserId(String userId);
	List<Rating> getAllRatingByHotelId(String hotelId);
}
