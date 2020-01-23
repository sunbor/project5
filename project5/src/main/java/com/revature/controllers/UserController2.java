package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.User;

@Controller
public class UserController2 {
		
	//get users by username and password
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<User> login(@RequestBody User u){
		//first find user with given username
		//if not found, return not found status code
		//then see if password corresponds
		//if no, return invalid credentials status code
		//otherwise, either remove password from object and return user or return user dto
		return null;
	}

}
