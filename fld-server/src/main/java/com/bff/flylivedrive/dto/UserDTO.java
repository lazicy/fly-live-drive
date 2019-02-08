package com.bff.flylivedrive.dto;

import java.util.List;

import com.bff.flylivedrive.model.Authority;
import com.bff.flylivedrive.model.User;

public class UserDTO {
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String city;
	private int bonus_points;
	private boolean active;
	private boolean firstLog;

	private List<Authority> authorities;
	
	public UserDTO() {
		
	}
	
	public UserDTO(String username, String password, String firstname, String lastname, String email, String city, int bonus_points, boolean active, boolean firstLog, List<Authority> auth) {
		super();
		this.username = username;
		this.setPassword(password);
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.setCity(city);
		this.bonus_points = bonus_points;
		this.active = active;
		this.firstLog = firstLog;
		this.authorities = auth;
	}


	// konverzija iz modela u DTO
	public UserDTO(User user) {
		this(user.getUsername(),user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getCity(), user.getBonus_points(), user.isActive(), user.isFirstLog(), (List<Authority>) user.getAuthorities());
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public boolean isFirstLog() {
		return firstLog;
	}

	public void setFirstLog(boolean firstLog) {
		this.firstLog = firstLog;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getBonus_points() {
		return bonus_points;
	}

	public void setBonus_points(int bonus_points) {
		this.bonus_points = bonus_points;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

}
