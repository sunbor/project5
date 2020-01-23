package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Digimon;

@Repository
public class DigimonDao implements IDigimonDao {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public void save(Digimon d) {
		Session s = sf.getCurrentSession();
		s.save(d);
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Digimon> getAll() {
		Session s = sf.getCurrentSession();
		List<Digimon> digiList = s.createCriteria(Digimon.class).list();
		if(digiList.size() == 0) {
			//TODO: log user not found
			return null;
		}
		return digiList;
	}

	
	
}
