package com.bff.flylivedrive.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.bff.flylivedrive.dto.UserDTO;
import com.bff.flylivedrive.model.RentAdmin;
import com.bff.flylivedrive.model.User;
import com.bff.flylivedrive.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserService userService;
	/*
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		
		System.out.println("getAllUsers");
		
		List<User> users = userService.findAll();
		List<UserDTO> usersDTO = new ArrayList<>();
		
		// konverzija u DTO
		for (User u: users) {
			UserDTO uDTO = new UserDTO(u);
			usersDTO.add(uDTO);
		}
		
		return new ResponseEntity<>(usersDTO, HttpStatus.OK);
		
		
	}*/
	
	//prilikom sign-up se uvek kreira korisnik tipa User
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO, HttpServletRequest request) throws MailException, InterruptedException {
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setCity(userDTO.getCity());
		
		user = userService.save(user);
		
		userService.sendNotificationSync(user, request);
		
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	public RedirectView verifyMail() {
		RedirectView rv = new RedirectView();
		rv.setUrl("localhost:4200/login");
		return rv;
	}
	
	@RequestMapping(value= "/setActive", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<UserDTO> setActive(@RequestBody UserDTO userDTO) throws URISyntaxException{
		/*userDTO.setActive(true);
		
		
		user = userService.save(user);
		
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		String path = url.replace(uri, "") + "/api/test";
		HttpHeaders header = new HttpHeaders();
		URI location = new URI(path);
		header.setLocation(location);
		//OK code status za odgovor na uspesan put request i redirekcija na pocetnu
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
		*/
		return null;
	}
	
	
}

