package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Hotel;

public class HotelDTO {
	
	private Long id;
	private String name;
	private String address;
	private String city;
	private String country;
	private String description;
	private String hotelImageURL;
	private String map;
	private int stars;
	
	public HotelDTO() {
		
	}
	
	public HotelDTO(Hotel h) {
		this(h.getId(), h.getName(), h.getAddress(), h.getCity(), h.getCountry(), h.getDescription(), h.getHotelImageURL(), h.getMap(), h.getStars());
	}
	
	public HotelDTO(Long id, String name, String address, String city, String country, String description, String imageURL, String map, int stars) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.description = description;
		this.hotelImageURL = imageURL;
		this.map = map;
		this.stars = stars;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
	
}
