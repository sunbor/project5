package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Digimon;
import com.revature.repositories.IDigimonDao;

@RestController
public class DigimonController {
	
	@Autowired
	IDigimonDao digimonDao;
	
	@PostMapping("/users/{id}/digimon")
	public ResponseEntity<Boolean> saveDigimon(@RequestBody Digimon caughtDigimon) {
		
		System.out.println(caughtDigimon);
		
		boolean saveSuccess = digimonDao.save(caughtDigimon);
		
		return ResponseEntity.ok(saveSuccess);
	}

}
