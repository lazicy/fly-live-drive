package com.bff.flylivedrive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bff.flylivedrive.model.Room;


public interface RoomRepository extends JpaRepository<Room, Long> {
	
	Room findOneById(Long id);
	
	@Query("select r from Room r where r.hotel.id = :id")
	List<Room> findByHotel(@Param("id") Long id);
	
}
