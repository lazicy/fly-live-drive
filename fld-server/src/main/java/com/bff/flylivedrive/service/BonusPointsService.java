package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bff.flylivedrive.model.BonusPoints;
import com.bff.flylivedrive.repository.BonusPointsRepository;

@Service
public class BonusPointsService {
	
	@Autowired
	private BonusPointsRepository bonusRepo;
	
	public BonusPoints findOneById(Long id) {
		return bonusRepo.findOneById(id);
	}
	
	public List<BonusPoints> findAll() {
		return bonusRepo.findAll();
	}
	
	//@Transactional
	public BonusPoints save(BonusPoints bonus) {
		return bonusRepo.save(bonus);
	}
	
	//@Transactional
	public void remove(Long id) {
		bonusRepo.deleteById(id);
	}
	
}
