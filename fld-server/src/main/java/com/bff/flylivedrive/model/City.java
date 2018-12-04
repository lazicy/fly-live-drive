package com.bff.flylivedrive.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@OneToMany(mappedBy = "departureCity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Flight> departureFlights = new HashSet<Flight>();
	
	@OneToMany(mappedBy = "landingCity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Flight> landingFlights = new HashSet<Flight>();
	
	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Interception> interceptions = new HashSet<Interception>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Flight> getDepartureFlights() {
		return departureFlights;
	}

	public void setDepartureFlights(Set<Flight> departureFlights) {
		this.departureFlights = departureFlights;
	}

	public Set<Flight> getLandingFlights() {
		return landingFlights;
	}

	public void setLandingFlights(Set<Flight> landingFlights) {
		this.landingFlights = landingFlights;
	}

	public Set<Interception> getInterceptions() {
		return interceptions;
	}

	public void setInterceptions(Set<Interception> interceptions) {
		this.interceptions = interceptions;
	}
	
	
	
	

}
