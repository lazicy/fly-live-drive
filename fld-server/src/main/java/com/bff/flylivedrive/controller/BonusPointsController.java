package com.bff.flylivedrive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bff.flylivedrive.dto.BonusPointsDTO;
import com.bff.flylivedrive.model.BonusPoints;
import com.bff.flylivedrive.service.BonusPointsService;

@RestController
@RequestMapping(value = "/bonus")
public class BonusPointsController {
	
	@Autowired
	BonusPointsService bonusService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<BonusPointsDTO>> getAllBonuses() {
		
		List<BonusPoints> bonuses = bonusService.findAll();
		List<BonusPointsDTO> bonusDTO = new ArrayList<>();
		for (BonusPoints b : bonuses) {
			BonusPointsDTO bDTO = new BonusPointsDTO(b);
			bonusDTO.add(bDTO);
		}
		
		return new ResponseEntity<>(bonusDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<BonusPointsDTO> saveBonus(@RequestBody BonusPointsDTO bonusDTO) {
		
		BonusPoints bonus = new BonusPoints();
		
		bonus.setPoints(bonusDTO.getPoints());
		bonus.setDiscount(bonusDTO.getDiscount());
		
		bonus = bonusService.save(bonus);
		
		return new ResponseEntity<BonusPointsDTO>(new BonusPointsDTO(bonus),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBonus(@PathVariable Long id){
		
		BonusPoints bonus = bonusService.findOneById(id);
		
		if (bonus == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		bonusService.remove(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
