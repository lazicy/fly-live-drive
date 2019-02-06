package com.bff.flylivedrive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	@Column(name="booked", nullable = false)
	private boolean booked;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Hotel hotel;
	
	// Prosecna ocena i Ocene(OneToMany)
	
	public Room() {
		super();
		booked = false;
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

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
