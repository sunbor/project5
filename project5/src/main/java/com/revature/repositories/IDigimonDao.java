package com.revature.repositories;

import java.util.List;

import com.revature.models.Digimon;

public interface IDigimonDao {
	
	public boolean save(Digimon d);
	
	public List<Digimon> getAll();
	
	public List<Digimon> getByUserId(int userId);
	
	public void delete(int id);

}
