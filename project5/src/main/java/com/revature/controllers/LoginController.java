package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.models.LoginInfo;
import com.revature.models.User;

@Controller
@CrossOrigin
public class LoginController {

	// Log in, send back user data, and set session
	// this looks good, explore web.xml to avoid CORS errors
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody LoginInfo u) {
		System.out.println("we're here");
		String username = u.getUsername();
		String password = u.getPassword();
		User loggedIn = UserDao.getByUsernameAndPassword(username, password);
		if (loggedIn == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(loggedIn);
		}

	}
}