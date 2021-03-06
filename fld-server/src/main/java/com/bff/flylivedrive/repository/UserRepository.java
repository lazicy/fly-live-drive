package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bff.flylivedrive.model.RentAdmin;
import com.bff.flylivedrive.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findOneByUsername(String username);
	
}
