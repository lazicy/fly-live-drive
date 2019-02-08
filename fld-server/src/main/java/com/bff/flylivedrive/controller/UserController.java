package com.bff.flylivedrive.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.bff.flylivedrive.dto.UserDTO;
import com.bff.flylivedrive.dto.UserInfoDTO;
import com.bff.flylivedrive.model.Authority;
import com.bff.flylivedrive.model.AvioAdmin;
import com.bff.flylivedrive.model.HotelAdmin;
import com.bff.flylivedrive.model.RentAdmin;
import com.bff.flylivedrive.model.SysAdmin;
import com.bff.flylivedrive.model.User;
import com.bff.flylivedrive.security.TokenUtils;
import com.bff.flylivedrive.service.CustomUserDetailsService;
import com.bff.flylivedrive.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		
		List<User> users = userService.findAll();
		List<UserDTO> usersDTO = new ArrayList<>();
		
		// konverzija u DTO
		for (User u: users) {
			UserDTO uDTO = new UserDTO(u);
			usersDTO.add(uDTO);
		}
		
		return new ResponseEntity<>(usersDTO, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getUser",method = RequestMethod.GET)
	public String getUser(HttpServletRequest request) {
		String token = tokenUtils.getToken(request);
		System.out.println("token: "+token);
		String username = tokenUtils.getUsernameFromToken(token);
		System.out.println("Name: "+username);
		return username;
	}
	
	@RequestMapping(value = "/info",method = RequestMethod.GET)
	public UserInfoDTO getUserInfo(HttpServletRequest request) {
		String token = tokenUtils.getToken(request);
		System.out.println("token: "+token);
		String username = tokenUtils.getUsernameFromToken(token);

		User u = userService.findOneByUsername(username);
		
		return new UserInfoDTO(u);
	}
	
	
	
	//prilikom sign-up se uvek kreira korisnik tipa User
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO, HttpServletRequest request) throws MailException, InterruptedException {
		User user = new User();
		user.setUsername(userDTO.getUsername());
		//password se provlaci kroz hash funkciju (BCryptEncoder)
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());
		user.setCity(userDTO.getCity());
		Authority a = new Authority();
		a.setId((long) 5);
		a.setName("USER");
		List<Authority> al = new ArrayList<Authority>();
		al.add(a);
		user.setAuthorities(al);
		
		user = userService.save(user);
		
		userService.sendNotificationSync(user, request);
		
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/verify/{username}", method = RequestMethod.GET)
	public RedirectView verifyMail(@PathVariable String username,HttpServletRequest request) {
		RedirectView rv = new RedirectView();
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		String path = url.replace(uri, "") + "/verifymail";
		
		User user = new User();
		user = userService.findOneByUsername(username);
		user.setActive(true);
		user = userService.save(user);
		
		rv.setUrl(path);
		return rv;
	}
	
	@RequestMapping(value= "/regAdmin/{role}", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity <UserDTO> regAdmin(@RequestBody UserDTO userDTO, @PathVariable String role, HttpServletRequest request) throws MailException, InterruptedException {
		User user;
		Authority a = new Authority();
		
		if(role.equals("RENT_ADMIN")) {
			a.setId((long) 1);
			a.setName(role);
			user = new RentAdmin();
		} else if (role.equals("HOTEL_ADMIN")) {
			a.setId((long) 2);
			a.setName(role);
			user = new HotelAdmin();
		} else if (role.equals("AVIO_ADMIN")) {
			a.setId((long) 3);
			a.setName(role);
			user = new AvioAdmin();
		} else {
			a.setId((long) 4);
			a.setName(role);
			user = new SysAdmin();
		}
		
		user.setUsername(userDTO.getUsername());
		//password se provlaci kroz hash funkciju (BCryptEncoder)
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());
		user.setCity(userDTO.getCity());
		
		List<Authority> al = new ArrayList<Authority>();
		al.add(a);
		user.setAuthorities(al);
		
		user = userService.save(user);
		
		userService.sendNotificationSync(user, request);
		
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
	}
	
}

