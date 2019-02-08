package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.Room;
import com.bff.flylivedrive.repository.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	RoomRepository sobaRepo;
	
	public Room findOneById(Long id) {
		return sobaRepo.findOneById(id);
	}
	
	
	public Room save (Room soba) {
		return sobaRepo.save(soba);
	}
	
	public void remove(Long id) {
		sobaRepo.deleteById(id);
	}
	
	public List<Room> findByHotel(Long id) {
		return sobaRepo.findByHotel(id);
	}

}
