package com.bff.flylivedrive.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Filijala;
import com.bff.flylivedrive.model.VehicleReservation;
import com.bff.flylivedrive.model.Vozilo;
import com.bff.flylivedrive.repository.VoziloRepository;

@Service
public class VoziloService {
	
	@Autowired
	private VoziloRepository voziloRepo;
	
	public Vozilo findOneById(Long id) {
		return voziloRepo.findOneById(id);
	}
	
	public List<Vozilo> findAll(){
		return voziloRepo.findAll();
	}
	
	public Vozilo save(Vozilo v) {
		return voziloRepo.save(v);
	}
	public void deleteById(Long id) {
		voziloRepo.deleteById(id);
	}
	
	public List<Vozilo> getNotResVehicles(Long city) {
		return voziloRepo.getNotResVehicles(city);
	}
	public List<Vozilo> getNotResVehicles(Long city, int seats) {
		return voziloRepo.getNotResVehicles(city, seats);
	}
	
	public List<Vozilo> getResVehicles(Date pickUpDate, Date dropOffDate,Long city){
		return voziloRepo.getResVehicles(pickUpDate, dropOffDate, city);
	}
	
	public List<Vozilo> getResVehicles(Date pickUpDate, Date dropOffDate, Long city, int seats){
		return voziloRepo.getResVehicles(pickUpDate, dropOffDate, city, seats);
	}
	
	public List<Vozilo> findAllByCityId(Long id){
		return voziloRepo.findAllByCityId(id);
	}
}
