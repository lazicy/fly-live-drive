package com.bff.flylivedrive.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Seat {

@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private boolean reserved = false;
	
	private int row;
	
	private String place;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Flight flight;
	

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private FlightReservation reservationDeparture;
	

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private FlightReservation reservationReturn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	
	
	
}
