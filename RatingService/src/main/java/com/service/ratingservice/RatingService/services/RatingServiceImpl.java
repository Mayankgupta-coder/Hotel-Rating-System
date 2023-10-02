package com.service.ratingservice.RatingService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ratingservice.RatingService.dao.RatingDao;
import com.service.ratingservice.RatingService.entities.Rating;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDao ratingDao;
	
	@Override
	public Rating createRating(Rating rating) {
		// TODO Auto-generated method stub
		String id=UUID.randomUUID().toString();
		rating.setRatingId(id);
		return ratingDao.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		return ratingDao.findAll();
	}

	@Override
	public List<Rating> getAllRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingDao.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingDao.findByHotelId(hotelId);
	}

}
