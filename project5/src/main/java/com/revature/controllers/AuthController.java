package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
	
//	@RequestMapping(value = "/*", method = RequestMethod.POST)
	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String auth( ) {
		return "auth";
	//	return "localhost:8080/project5/auth" *i'm just thinking something... dont mind this; I'll ask questions*
	}

}
