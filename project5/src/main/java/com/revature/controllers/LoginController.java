package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.repositories.IUserDao;

@RestController
public class LoginController {
	
	@Autowired
	IUserDao userDao;

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User u){
		System.out.println("inside post method");
		return ResponseEntity.ok(userDao.getByUsernameAndPassword(u.getUsername(), u.getPassword()));
		
	}
}
