package com.revature.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.User;



public class UserService {
	@Autowired
	private com.revature.repositories.UserRepository userRepository;

	public UserService() {
		super();
	}

	public UserService(com.revature.repositories.UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public com.revature.repositories.UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(com.revature.repositories.UserRepository userRepository) {
		System.out.println("Inside UserRepository Setter");
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public String toString() {
		return "UserService [userRepository=" + userRepository + "]";
	}

	public static User findById(int id) {
		return null; //connect to database here
	}

	public boolean ifUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	public void update(User currentUser) {
		// TODO Auto-generated method stub
		
	}
}

