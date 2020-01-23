package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class LoginInfo {

	private String username;
	private String password;

	public LoginInfo() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

}
