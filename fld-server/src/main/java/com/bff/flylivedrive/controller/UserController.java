package com.bff.flylivedrive.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.bff.flylivedrive.dto.HotelDTO;
import com.bff.flylivedrive.dto.UserDTO;
import com.bff.flylivedrive.model.Authority;
import com.bff.flylivedrive.model.RentAdmin;
import com.bff.flylivedrive.model.User;
import com.bff.flylivedrive.model.UserTokenState;
import com.bff.flylivedrive.security.TokenUtils;
import com.bff.flylivedrive.security.auth.JwtAuthenticationRequest;
import com.bff.flylivedrive.service.CustomUserDetailsService;
import com.bff.flylivedrive.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
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
	
	@RequestMapping(value = "/getUser",method = RequestMethod.GET, consumes = "application/json")
	public User user(Principal user) {
		return this.userService.findOneByUsername(user.getName());
	}
	
	//prilikom sign-up se uvek kreira korisnik tipa User
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO, HttpServletRequest request) throws MailException, InterruptedException {
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
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
	
	@RequestMapping(value= "/changeRole", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity <UserDTO> changeRole(@RequestBody UserDTO userDTO){
		
		User user = userService.findOneByUsername(userDTO.getUsername());
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		user.setAuthorities(userDTO.getAuthorities());
		
		user = userService.save(user);
		
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
	}
	
}

