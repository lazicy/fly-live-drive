package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.BonusPoints;

public interface BonusPointsRepository extends JpaRepository<BonusPoints, Long> {
	
	BonusPoints findOneById(Long id);
}
