package com.service.userservice.UserService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.userservice.UserService.dao.UserDao;
import com.service.userservice.UserService.entities.User;
import com.service.userservice.UserService.exception.ResourceNotFoundException;
import com.service.userservice.UserService.models.Hotel;
import com.service.userservice.UserService.models.Rating;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		String id=UUID.randomUUID().toString();
		user.setId(id);
		return userDao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User>users=userDao.findAll();
		users.stream().forEach((user)->{
			List<Rating> ratings=ratingService.getAllRatingsByUserId(user.getId());
			
			ratings.stream().forEach((rating)->{
				String hotelId=rating.getHotelId();
				Hotel hotel=hotelService.getHotel(hotelId);
				rating.setHotel(hotel);
			});
			user.setRating(ratings);
		});
		return users;
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user=userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id " + userId +" not found"));
		
		List<Rating> ratings=ratingService.getAllRatingsByUserId(userId);
		
		ratings.stream().forEach((rating)->{
			String hotelId=rating.getHotelId();
			Hotel hotel=hotelService.getHotel(hotelId);
			rating.setHotel(hotel);
		});
		user.setRating(ratings);
		return user;
	}

}
