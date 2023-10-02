package com.service.ratingservice.RatingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ratingservice.RatingService.entities.Rating;
import com.service.ratingservice.RatingService.services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating createdRating=ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings() {
		List<Rating> ratings=ratingService.getAllRatings();
		return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId) {
		List<Rating> ratings=ratingService.getAllRatingByUserId(userId);
		return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId) {
		List<Rating> ratings=ratingService.getAllRatingByHotelId(hotelId);
		return ResponseEntity.ok(ratings);
	}
}
