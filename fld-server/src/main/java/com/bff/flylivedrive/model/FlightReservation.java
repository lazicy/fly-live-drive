package com.bff.flylivedrive.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FlightReservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String tripType;
	
	private Date reservationDate;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Flight departureFlight;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Flight returnFlight;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private double totalPrice;
	
	@OneToMany(mappedBy = "reservationDeparture", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Seat> departureSeats = new ArrayList<>();

	@OneToMany(mappedBy = "reservationReturn", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Seat> returnSeats = new ArrayList<>();

	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	private GlobalReservation globalReservation;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

	public Flight getDepartureFlight() {
		return departureFlight;
	}

	public void setDepartureFlight(Flight departureFlight) {
		this.departureFlight = departureFlight;
	}

	public Flight getReturnFlight() {
		return returnFlight;
	}

	public void setReturnFlight(Flight returnFlight) {
		this.returnFlight = returnFlight;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public List<Seat> getDepartureSeats() {
		return departureSeats;
	}

	public void setDepartureSeats(List<Seat> departureSeats) {
		this.departureSeats = departureSeats;
	}

	public List<Seat> getReturnSeats() {
		return returnSeats;
	}

	public void setReturnSeats(List<Seat> returnSeats) {
		this.returnSeats = returnSeats;
	}

	public GlobalReservation getGlobalReservation() {
		return globalReservation;
	}

	public void setGlobalReservation(GlobalReservation globalReservation) {
		this.globalReservation = globalReservation;
	}
	
	
	
	
	
}
