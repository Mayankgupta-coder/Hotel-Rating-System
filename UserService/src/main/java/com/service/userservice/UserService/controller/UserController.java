package com.service.userservice.UserService.controller;

import java.util.ArrayList;
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

import com.service.userservice.UserService.entities.User;
import com.service.userservice.UserService.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser=userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	@GetMapping("/{userId}")
	@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod="ratingHotelFallback")
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		User user=userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	public ResponseEntity<User> ratingHotelFallback(String userId,Exception e) {
		User user=new User();
		user.setName("dummy");
		user.setEmail("dummy@gmail.com");
		user.setAbout("This is a dummy user");
		user.setId("dummyId");
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	@CircuitBreaker(name="ratingHotelBreakerAllUsers",fallbackMethod="ratingHotelFallbackAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users=userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	public ResponseEntity<List<User>> ratingHotelFallbackAllUsers(Exception e) {
		User user=new User();
		user.setName("dummy");
		user.setEmail("dummy@gmail.com");
		user.setAbout("This is a dummy user");
		user.setId("dummyId");
		List<User>users=new ArrayList<>();
		users.add(user);
		return ResponseEntity.ok(users);
	}
}
