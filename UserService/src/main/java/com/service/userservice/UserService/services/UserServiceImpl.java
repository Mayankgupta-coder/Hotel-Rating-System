package com.service.userservice.UserService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.userservice.UserService.dao.UserDao;
import com.service.userservice.UserService.entities.User;
import com.service.userservice.UserService.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
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
		return userDao.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id " + userId +" not found"));
	}

}
