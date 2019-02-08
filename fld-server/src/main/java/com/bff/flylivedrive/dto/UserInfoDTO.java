package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.User;

public class UserInfoDTO {
	
	private String username;
	private String firstName;
	private String lastName;
	private String city;
	private String email;
	private boolean active;
	private GlobalReservationDTO globalDTO;
	
	public UserInfoDTO() {
		
	}
	
	public UserInfoDTO(User u) {
		
		this(u.getUsername(), u.getFirstname(), u.getLastname(), u.getCity(), u.getEmail(), u.isActive());
		
	}
	

	
	public UserInfoDTO(String username, String firstName, String lastName, String city, String email, boolean active) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.email = email;
		this.active = active;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public GlobalReservationDTO getGlobalDTO() {
		return globalDTO;
	}

	public void setGlobalDTO(GlobalReservationDTO globalDTO) {
		this.globalDTO = globalDTO;
	}
	
	

}
