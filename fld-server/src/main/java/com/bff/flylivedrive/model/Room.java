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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="no_of_beds", nullable = false)
	private Integer beds;
	
	@Column(name="people_capacity", nullable = false)
	private Integer people_capacity;
	
	@Column(name="price", nullable = false)
	private Double price;
	
	@Column(name="floor", nullable = false)
	private Integer floor;
	
	@Column(name="balcony", nullable = false)
	private String balcony;
	
	@OneToMany(mappedBy="room", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<FastRoom> fast_res = new HashSet<FastRoom>();
	
	@Column(name="rating", nullable = true)
	private Double rating;
	
	@OneToMany(mappedBy="room", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<HotelReservation> hotel_res = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Hotel hotel;
	
	// Prosecna ocena i Ocene(OneToMany)
	
	public Room() {
		super();
		rating = 0.0;
	}

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

	public Integer getBeds() {
		return beds;
	}

	public void setBeds(Integer beds) {
		this.beds = beds;
	}

	public Integer getPeople_capacity() {
		return people_capacity;
	}

	public void setPeople_capacity(Integer people_capacity) {
		this.people_capacity = people_capacity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getBalcony() {
		return balcony;
	}

	public void setBalcony(String balcony) {
		this.balcony = balcony;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Set<FastRoom> getFast_res() {
		return fast_res;
	}

	public void setFast_res(Set<FastRoom> fast_res) {
		this.fast_res = fast_res;
	}

	public Set<HotelReservation> getHotel_res() {
		return hotel_res;
	}

	public void setHotel_res(Set<HotelReservation> hotel_res) {
		this.hotel_res = hotel_res;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
