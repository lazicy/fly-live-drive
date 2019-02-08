package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.FastResVehicle;
import com.bff.flylivedrive.repository.FastResVehicleRepository;
@Service
public class FastResVehicleService {
	
	@Autowired
	private FastResVehicleRepository resRepo;
	
	public FastResVehicle findOneById(Long id) {
		return resRepo.findOneById(id);
	}
	
	public List<FastResVehicle> findAll(){
		return resRepo.findAll();
	}
	
	public FastResVehicle save(FastResVehicle fresv) {
		return resRepo.save(fresv);
	}
	
	public List<FastResVehicle> getAllforRent(Long id){
		return resRepo.getAllForRent(id);
	}
	
}
