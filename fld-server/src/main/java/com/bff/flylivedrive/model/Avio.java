package com.bff.flylivedrive.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
public class Avio {
	
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name="address", nullable = false)
	private String address;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private City city;
	
	@Column(name="map", columnDefinition="TEXT", nullable = true)
	private String map;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	
	@OneToMany(mappedBy = "avio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Flight> flights = new HashSet<Flight>();
	
	
	@OneToMany(mappedBy = "avio", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Destination> destinations = new HashSet<Destination>();
	
	
	
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

	public String getDescription() {
		return description;
	}
	
	

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}
	

	public Set<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(Set<Destination> destinations) {
		this.destinations = destinations;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	

}
