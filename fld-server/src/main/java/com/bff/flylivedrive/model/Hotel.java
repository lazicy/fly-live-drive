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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name="address", nullable = false)
	private String address;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private City city;

	@Column(name="description", columnDefinition="TEXT", nullable = true)
	private String description;
	
	@Column(name="hotelImageURL", nullable = true)
	private String hotelImageURL;
	
	@Column(name="map", columnDefinition="TEXT", nullable = true)
	private String map;
	
	@Column(name="stars", nullable = false)
	private int stars;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Room> sobe = new HashSet<Room>();
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Usluga> usluge = new HashSet<Usluga>();
	
	//Ocena
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHotelImageURL() {
		return hotelImageURL;
	}

	public void setHotelImageURL(String imageURL) {
		this.hotelImageURL = imageURL;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public Set<Room> getSobe() {
		return sobe;
	}

	public void setSobe(Set<Room> sobe) {
		this.sobe = sobe;
	}

	public Set<Usluga> getUsluge() {
		return usluge;
	}

	public void setUsluge(Set<Usluga> usluge) {
		this.usluge = usluge;
	}

}
