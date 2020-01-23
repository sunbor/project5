package com.revature.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Digimon;
import com.revature.models.User;
import com.revature.repositories.IDigimonDao;
import com.revature.repositories.IUserDao;

public class TestDriver {
	public static void main(String[] args) {
		//testSaveUser();
		testSaveDigimon();
		//testGetUserByUsername();
		//testGetUserByUsernameAndPassword();
	}

	private static void testSaveUser() {
		User testUser = new User(0, "testrob", "pass", null);
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IUserDao dao = (IUserDao) ac.getBean("userDao");
		
		dao.save(testUser);
		
	}
	
	private static void testSaveDigimon() {
		Digimon testDigimon = new Digimon(0, "testDigi", "hi.jpg", "rookie", null);
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IDigimonDao dao = (IDigimonDao) ac.getBean("digimonDao");
		
		dao.save(testDigimon);
		
	}
	
	private static void testGetUserByUsername() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao dao = (IUserDao) ac.getBean("userDao");

		System.out.println(dao.getByUsername("testbob"));
	}
	
	private static void testGetUserByUsernameAndPassword() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao dao = (IUserDao) ac.getBean("userDao");

		System.out.println(dao.getByUsernameAndPassword("testbob", "passs"));
	}
}
