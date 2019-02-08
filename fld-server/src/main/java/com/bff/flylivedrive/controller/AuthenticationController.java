package com.bff.flylivedrive.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.bff.flylivedrive.model.User;
import com.bff.flylivedrive.model.UserTokenState;
import com.bff.flylivedrive.security.TokenUtils;
import com.bff.flylivedrive.security.auth.JwtAuthenticationRequest;
import com.bff.flylivedrive.service.CustomUserDetailsService;
import com.bff.flylivedrive.service.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
	
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ResponseEntity<?> loginUser(@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response, Device device){
		
		final Authentication authentication = manager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		User user = (User) authentication.getPrincipal();
		
		if(!user.isActive()) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		// ako je null onda nije dobra sifra ili password
		if(user == null) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		String jwt = tokenUtils.generateToken(user.getUsername(), device);
		
		int expiresIn = 6000;
		return ResponseEntity.ok(new UserTokenState(jwt,expiresIn));
	}
}
