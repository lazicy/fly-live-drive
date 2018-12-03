package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.RentAdmin;
import com.bff.flylivedrive.model.User;

public class UserDTO {
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String city;
	
	public UserDTO() {
		
	}
	
	public UserDTO(String username, String firstname, String password , String lastname, String email, String city) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.setPassword(password);
		this.setCity(city);
	}


	// konverzija iz modela u DTO
	public UserDTO(User user) {
		this(user.getUsername(),user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getCity());
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

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
