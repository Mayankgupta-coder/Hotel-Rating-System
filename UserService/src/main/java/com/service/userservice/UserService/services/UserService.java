package com.service.userservice.UserService.services;

import java.util.List;

import com.service.userservice.UserService.entities.User;

public interface UserService {

	User createUser(User user);
	
	List<User> getAllUsers();
	
	User getUser(String userId);
}
