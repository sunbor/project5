package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.models.User;
import com.revature.services.UserService;

@Controller
public class LoginController {

	
	//Log in, send back user data, and set session
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login() {
		String username = "";//fix this later
		String password = "";//fix this later
		return UserService.login(username, password);
	}
}