package com.service.userservice.UserService.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.service.userservice.UserService.models.Rating;

@Entity
public class User {

	@Id
	private String id;
	
	@Column(nullable = false,name = "name")
	private String name;
	
	@Column(nullable = false,name = "email")
	private String email;
	
	@Column(nullable = false,name = "about")
	private String about;
	
	@Transient
	private List<Rating> rating=new ArrayList<>();


	public User(String id, String name, String email, String about, List<Rating> rating) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.about = about;
		this.rating = rating;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	
	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", about=" + about + ", rating=" + rating
				+ "]";
	}
	
}
