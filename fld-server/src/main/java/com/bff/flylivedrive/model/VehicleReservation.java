package com.bff.flylivedrive.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class VehicleReservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "pick_up_location", nullable = false)
	String pickUpLocation;
	
	@Column(name = "drop_off_location", nullable = false)
	String dropOffLocation;
	
	@Column(name = "pick_up_date", nullable = false)
	Date pickUpDate;
	
	@Column(name = "drop_off_date", nullable = false)
	Date pickOffDate;
	
	@Column(name = "pick_up_time", nullable = false)
	String pickUpTime;
	
	@Column(name = "drop_off_time", nullable = false)
	String dropOffTime;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	City city;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	User user;
	
	
	public VehicleReservation() {
		
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPickUpLocation() {
		return pickUpLocation;
	}


	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}


	public String getDropOffLocation() {
		return dropOffLocation;
	}


	public void setDropOffLocation(String dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}


	public Date getPickUpDate() {
		return pickUpDate;
	}


	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}


	public Date getPickOffDate() {
		return pickOffDate;
	}


	public void setPickOffDate(Date pickOffDate) {
		this.pickOffDate = pickOffDate;
	}


	public String getPickUpTime() {
		return pickUpTime;
	}


	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}


	public String getDropOffTime() {
		return dropOffTime;
	}


	public void setDropOffTime(String dropOffTime) {
		this.dropOffTime = dropOffTime;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
}
