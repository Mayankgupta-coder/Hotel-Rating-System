package com.service.userservice.UserService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.userservice.UserService.entities.User;

public interface UserDao extends JpaRepository<User,String> {

}
