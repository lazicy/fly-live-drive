package com.bff.flylivedrive.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Destination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Avio avio;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private City city;
	
	@OneToMany(mappedBy = "departureDestination", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Flight> departureFlights = new HashSet<Flight>();
	
	@OneToMany(mappedBy = "landingDestination", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Flight> landingFlights = new HashSet<Flight>();
	
	@OneToMany(mappedBy = "destination", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Interception> interceptions = new HashSet<Interception>();
	

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Avio getAvio() {
		return avio;
	}

	public void setAvio(Avio avio) {
		this.avio = avio;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	
	
	

}
