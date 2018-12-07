package com.bff.flylivedrive.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Inheritance(strategy=SINGLE_TABLE) //ovom anotacijom se naglasava tip mapiranja "jedna tabela po hijerarhiji"
@DiscriminatorColumn(name="type", discriminatorType=STRING) //ovom anotacijom se navodi diskriminatorska kolona
public class User {
	
	@Id
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "firstname", nullable = false)
	private String firstname;
	
	@Column(name = "lastname", nullable = false)
	private String lastname;
	
	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "active", nullable = false)
	private boolean active = false; //inicijalno je uvek false prilikom registracije, menja se nakon potvrde mejlom
	
	public User() {
		super();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
