package com.revature.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Digimon;
import com.revature.models.User;
import com.revature.repositories.IDigimonDao;
import com.revature.repositories.IUserDao;

public class TestDriver {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	private static IUserDao userDao = (IUserDao) ac.getBean("userDao");
	private static IDigimonDao digiDao = (IDigimonDao) ac.getBean("digimonDao");
	
	public static void main(String[] args) {
		//testSaveUser();
		//testSaveDigimon();
		//testGetUserByUsername();
		//testGetUserByUsernameAndPassword();
		//testGetAllDigimon();
		testGetUserById();
	}

	private static void testSaveUser() {
		User testUser = new User(0, "testbob", "pass", null);
		
		IUserDao dao = (IUserDao) ac.getBean("userDao");
		
		dao.save(testUser);
		
	}
	
	private static void testSaveDigimon() {
		Digimon testDigimon = new Digimon(0, 0, "testDigi2", "hello.jpg", "champion", null);
				
		IDigimonDao dao = (IDigimonDao) ac.getBean("digimonDao");
		
		System.out.println(dao.save(testDigimon));
		
	}
	
	private static void testGetUserByUsername() {
		IUserDao dao = (IUserDao) ac.getBean("userDao");

		System.out.println(dao.getByUsername("testbob"));
	}
	
	private static void testGetUserByUsernameAndPassword() {
		IUserDao dao = (IUserDao) ac.getBean("userDao");

		System.out.println(dao.getByUsernameAndPassword("testbob", "passs"));
	}
	
	private static void testGetAllDigimon() {
		IDigimonDao dao = (IDigimonDao) ac.getBean("digimonDao");
		
		System.out.println(dao.getAll());
	}
	
	private static void testGetUserById() {
		System.out.println(userDao.getById(202));
	}
}
