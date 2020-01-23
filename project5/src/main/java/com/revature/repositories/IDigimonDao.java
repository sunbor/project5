package com.revature.repositories;

import java.util.List;

import com.revature.models.Digimon;

public interface IDigimonDao {
	
	public void save(Digimon d);
	
	public List<Digimon> getAll();

}
