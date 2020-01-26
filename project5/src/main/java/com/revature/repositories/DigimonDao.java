package com.revature.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	public boolean save(Digimon d) {
		Session s = sf.getCurrentSession();
		Integer resultId = (Integer) s.save(d);
		return resultId.intValue() != 0;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	@Transactional
	public List<Digimon> getAll() {
		Session s = sf.getCurrentSession();
		List<Digimon> digiList = s.createCriteria(Digimon.class).list();
		if(digiList.size() == 0) {
			//TODO: log user not found
			return null;
		}
		return digiList;
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Digimon placeholder = new Digimon(id, 0, "oh no", "oh no", "dead", null);

		s.delete(placeholder);
	}
	
	//stupid broken garbage i hate everything
	@Override
	@Transactional
	public List<Digimon> getByUserId(int userId) {
		Session s = sf.getCurrentSession();
		List<Digimon> digiList = s.createCriteria(Digimon.class).add(Restrictions.like("partner", userId)).list();
		if(digiList.size() == 0) {
			//TODO: log no digimon owned
			return null;
		}
		return digiList;
	}

	
	
}
