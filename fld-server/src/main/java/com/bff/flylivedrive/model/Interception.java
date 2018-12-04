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

@Entity
public class Interception {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="takeOff", nullable=false)
	private Date takeOff;
	
	@Column(name="landing", nullable=false)
	private Date landing;
	
	@Column(name="duration", nullable=false)
	private int duration;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private City city;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Flight flight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTakeOff() {
		return takeOff;
	}

	public void setTakeOff(Date takeOff) {
		this.takeOff = takeOff;
	}

	public Date getLanding() {
		return landing;
	}

	public void setLanding(Date landing) {
		this.landing = landing;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
	
	
	
}
