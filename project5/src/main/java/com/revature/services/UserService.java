package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

@Service
public class UserService {

	static Session session = HibernateUtil.getSession();
	private static List<User> list = new ArrayList<>();

	static {// sample data
		list.add(new User(100, "test", "test", null));
	}

	public static User login(String username, String password) {
		try {
			String hql = "FROM users WHERE username = :username AND password = :password";
			Query<User> query = session.createQuery(hql);
			query.setParameter("username", username);
			query.setParameter("password", password);
			// List<User> list = query.list();
			return list.get(0);
		} catch (Exception e) {
			// log error that there was no user found
			return null;
		}
	}

	public static User findById(int id) {
		return null; // connect to Database here
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

	public List<User> findAll() {
		return null;
	}

}
