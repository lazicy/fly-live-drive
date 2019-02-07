package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.Room;


public interface RoomRepository extends JpaRepository<Room, Long> {
	
	Room findOneById(Long id);
	
}
