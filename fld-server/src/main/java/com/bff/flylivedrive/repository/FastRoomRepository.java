package com.bff.flylivedrive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bff.flylivedrive.model.FastRoom;

public interface FastRoomRepository extends JpaRepository<FastRoom, Long>{
	
	FastRoom findOneById(Long id);
	
	@Modifying
	@Query(value = "insert into fast_room_usluge (fast_room_id, usluge_id) values (?1, ?2)", nativeQuery = true)
	void addServices(Long fast_room_id, Long usluge_id);
	
	@Query("select f from FastRoom f where f.room = :id")
	List<FastRoom> findAllByRoomId(Long id);
}
