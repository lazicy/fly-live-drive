package com.bff.flylivedrive.dto;

import java.util.Date;

public class VehicleSearchParams {
	
	private String city;
	private Date pickUp;
	private Date dropOff;
	private int seats;
	
	public VehicleSearchParams(String city, Date pickUp, Date dropOff, int seats) {
		super();
		this.city = city;
		this.pickUp = pickUp;
		this.dropOff = dropOff;
		this.seats = seats;
	}
	public VehicleSearchParams() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getPickUp() {
		return pickUp;
	}
	public void setPickUp(Date pickUp) {
		this.pickUp = pickUp;
	}
	public Date getDropOff() {
		return dropOff;
	}
	public void setDropOff(Date dropOff) {
		this.dropOff = dropOff;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	
	
}
