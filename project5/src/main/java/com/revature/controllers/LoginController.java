package com.revature.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.LoginInfo;
import com.revature.models.User;
import com.revature.repositories.IUserDao;

@RestController
public class LoginController {
	
	private static Logger logger = LogManager.getLogger(LoginController.class);
	
	@Autowired
	IUserDao userDao;

	// ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	// IUserDao dao = (IUserDao) ac.getBean("userDao");

	// // Log in, send back user data, and set session
	// // this looks good, explore web.xml to avoid CORS errors
	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public ResponseEntity<User> login(@RequestBody LoginInfo u) {
	// 	String username = u.getUsername();
	// 	String password = u.getPassword();
	// 	User loggedIn = dao.getByUsernameAndPassword(username, password);
	// 	if (loggedIn == null) {
	// 		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	// 	} else {
	// 		return ResponseEntity.status(HttpStatus.ACCEPTED).body(loggedIn);
	// 	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody LoginInfo log){
		logger.trace("inside post method");
		logger.trace("login request: " + log);
		
		User respUser = userDao.getByUsernameAndPassword(log.getUsername(), log.getPassword());
		if(respUser == null) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		
		return ResponseEntity.ok(respUser);
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> register(@RequestBody LoginInfo reg){
		
		logger.trace(reg);
		
		//check if username is already taken
		if(userDao.getByUsername(reg.getUsername()) != null) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		
		//get username and password
		//put username and password into user object
		//send user object to database
		
		User newUser = new User(0, reg.getUsername(), reg.getPassword(), null);
		
		boolean saveSuccess = userDao.save(newUser);
		
		if(saveSuccess) {
			return ResponseEntity.ok(newUser);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.BAD_GATEWAY);
		}
	}
}
