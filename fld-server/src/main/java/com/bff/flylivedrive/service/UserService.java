package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.RentAdmin;
import com.bff.flylivedrive.model.User;
import com.bff.flylivedrive.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	//klasa Environment ocitava vrednosti iz application.properties fajla
	@Autowired
	private Environment env; 
	
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
	
	public void sendNotificationSync(User user) throws MailException, InterruptedException {
		Thread.sleep(10000);
		//System.out.println("Slanje emaila...");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Accaount verification");
		mail.setText("Hello " + user.getFirstname() + ",\n\n please click on the following link to verify your account: http://localhost:4200/api/users/verifymail/" + user.getUsername());
		
		javaMailSender.send(mail);
	}
}
