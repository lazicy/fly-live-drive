package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.RentAdmin;
import com.bff.flylivedrive.model.User;
import com.bff.flylivedrive.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User findOneByUsername(String username) {
		return userRepo.findOneByUsername(username);
	}
	
	public User save(User user) {
		return userRepo.save(user);
	}

}
