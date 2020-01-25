package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.CaughtDigimon;
import com.revature.models.Digimon;
import com.revature.models.User;
import com.revature.repositories.IDigimonDao;
import com.revature.repositories.IUserDao;

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
				caughtDigimon.getDigidexId(), 
				caughtDigimon.getDigimonName(), 
				caughtDigimon.getImgUrl(), 
				caughtDigimon.getDigimonLevel(), 
				currentUser);
		
		//save to database
		boolean saveSuccess = digimonDao.save(saveDigimon);
		
		if(saveSuccess) {
			return ResponseEntity.ok(saveSuccess);
		}
		else {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_GATEWAY);
		}
	}

}
