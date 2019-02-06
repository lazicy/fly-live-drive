package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Room;

public class RoomDTO {
	
	private Long id;
	private String name;
	private int beds;
	private int people_capacity;
	private double price;
	private int floor;
	private String balcony;
	private double rating;
	
	public RoomDTO() {
		
	}
	
	public RoomDTO(Room r) {
		this(r.getId(), r.getName(), r.getBeds(), r.getPeople_capacity(), r.getPrice(), r.getFloor(), r.getBalcony(), r.getRating());
	}
	
	public RoomDTO(Long id, String name, int beds, int people_capacity, double price, int floor, String balcony, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.beds = beds;
		this.people_capacity = people_capacity;
		this.price = price;
		this.floor = floor;
		this.balcony = balcony;
		this.rating = rating;
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

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public int getPeople_capacity() {
		return people_capacity;
	}

	public void setPeople_capacity(int people_capacity) {
		this.people_capacity = people_capacity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getBalcony() {
		return balcony;
	}

	public void setBalcony(String balcony) {
		this.balcony = balcony;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
}
