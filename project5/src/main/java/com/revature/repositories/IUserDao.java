package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

public interface IUserDao {
	
	public User getByUsername(String username);
	
	public User getByUsernameAndPassword(String username, String password);
	
	public User getById(int id);
	
	//for testing
	public List<User> getAll();
	
	public boolean save(User u);

}
