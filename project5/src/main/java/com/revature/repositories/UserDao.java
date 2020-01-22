package com.revature.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository
public class UserDao implements IUserDao {
	
	@Autowired
	private SessionFactory sf;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	@Transactional
	public User getByUsername(String username) {
		Session s = sf.getCurrentSession();
		

		List<User> userList = s.createCriteria(User.class).add(Restrictions.like("username", username)).list();
		if(userList.size()==0) {
			//TODO: log that user is not found
			return null;
		}
		return userList.get(0);
	}

	@Override
	@Transactional
	public User getByUsernameAndPassword(String username, String password) {
		Session s = sf.getCurrentSession();
		
		Criteria cri = s.createCriteria(User.class);
		
		cri.add(Restrictions.like("username", username));
		cri.add(Restrictions.like("password", password));
		
		List<User> userList = cri.list();
		
		if(userList.size()==0) {
			//TODO: log user not found
			return null;
		}
		return userList.get(0);
	}

	@Override
	@Transactional
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void save(User u) {
		Session s = sf.getCurrentSession();
		s.save(u);
		// TODO Auto-generated method stub
		
	}

}
