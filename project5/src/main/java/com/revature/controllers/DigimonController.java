package com.revature.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.CaughtDigimon;
import com.revature.models.Digimon;
import com.revature.models.User;
import com.revature.repositories.IDigimonDao;
import com.revature.repositories.IUserDao;
import com.revature.util.DexIdSort;

@RestController
public class DigimonController {
	
	@Autowired
	IDigimonDao digimonDao;
	
	@Autowired
	IUserDao userDao;
	
	@PostMapping("/users/{id}/digimon")
	public ResponseEntity<Boolean> saveDigimon(@RequestBody CaughtDigimon caughtDigimon) {
		
		//get user object from database
		//assign user object to digimon
		//save digimon
		
		System.out.println(caughtDigimon);
		
		//get user object from database
		User currentUser = userDao.getById(caughtDigimon.getUserId());
		
		//convert dto to digimon object
		Digimon saveDigimon = new Digimon(0, 
				caughtDigimon.getDigiDexId(), 
				caughtDigimon.getDigimonName(), 
				caughtDigimon.getImgUrl(), 
				caughtDigimon.getDigimonLevel(), 
				currentUser);
		
		//save to database
		boolean saveSuccess = digimonDao.save(saveDigimon);
		
		System.out.println(saveSuccess);
		
		if(saveSuccess) {
			return ResponseEntity.ok(saveSuccess);
		}
		else {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/users/{id}/digimon")
	public ResponseEntity<List<Digimon>> getDigimonList(@PathVariable("id") int id){
		//just call the dao
		//have status code feedback and stuff
				
		System.out.println("does it get here and what is id if so" + id);
		
		List<Digimon> digimonList = userDao.getById(id).getParty();
        Collections.sort(digimonList, new DexIdSort()); 
		
		if(digimonList == null) {
			return new ResponseEntity<List<Digimon>>(HttpStatus.NO_CONTENT);
		}
		else {
			return ResponseEntity.ok(digimonList);
		}
	}
	
	@DeleteMapping("/digimon/{id}")
	public ResponseEntity<Boolean> deleteDigimon(@PathVariable("id") int id){
		
		try {
			digimonDao.delete(id);
			return ResponseEntity.ok(true);
		}
		catch(HibernateOptimisticLockingFailureException e) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}

	}

}
