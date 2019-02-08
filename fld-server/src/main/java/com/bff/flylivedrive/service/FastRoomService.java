package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bff.flylivedrive.model.FastRoom;
import com.bff.flylivedrive.repository.FastRoomRepository;

@Service
public class FastRoomService {
	
	@Autowired
	FastRoomRepository fastRepo;
	
	public FastRoom findOneById(Long id) {
		return fastRepo.findOneById(id);
	}
	
	public List<FastRoom> findAll() {
		return fastRepo.findAll();
	}
	
	//@Transactional
	public FastRoom save (FastRoom fr) {
		return fastRepo.save(fr);
	}
	
	@Transactional
	public void addServices(Long fid, Long sid) {
		fastRepo.addServices(fid, sid);
	}
	
	public List<FastRoom> findAllByRoomId(Long id) {
		return fastRepo.findAllByRoomId(id);
	}
}
