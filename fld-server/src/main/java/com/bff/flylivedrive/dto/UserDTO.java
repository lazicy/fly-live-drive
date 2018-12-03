package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.RentAdmin;

public class UserDTO {
	
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	
	public UserDTO() {
		
	}
	
	public UserDTO(String username, String firstname, String lastname, String email) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}


	// konverzija iz modela u DTO
	public UserDTO(RentAdmin user) {
		this(user.getUsername(), user.getFirstname(), user.getLastname(), user.getEmail());
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
	
	
	

}
