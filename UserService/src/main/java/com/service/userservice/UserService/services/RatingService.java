package com.service.userservice.UserService.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service.userservice.UserService.models.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	@GetMapping("/rating/user/{userId}")
	List<Rating> getAllRatingsByUserId(@PathVariable String userId);
}
