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

	// ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	// IUserDao dao = (IUserDao) ac.getBean("userDao");

	// // Log in, send back user data, and set session
	// // this looks good, explore web.xml to avoid CORS errors
	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public ResponseEntity<User> login(@RequestBody LoginInfo u) {
	// 	System.out.println("we're here");
	// 	String username = u.getUsername();
	// 	String password = u.getPassword();
	// 	User loggedIn = dao.getByUsernameAndPassword(username, password);
	// 	if (loggedIn == null) {
	// 		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	// 	} else {
	// 		return ResponseEntity.status(HttpStatus.ACCEPTED).body(loggedIn);
	// 	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User u){
		System.out.println("inside post method");
		return ResponseEntity.ok(userDao.getByUsernameAndPassword(u.getUsername(), u.getPassword()));
		
	}
}
