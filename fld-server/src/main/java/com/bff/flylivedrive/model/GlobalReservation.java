package com.bff.flylivedrive.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class GlobalReservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private boolean active;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(nullable = true)
	private FlightReservation flightReservation;
	
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(nullable = true)
	private HotelReservation hotelReservation;

	// ovde dodajte i vase rezervacije
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(nullable = true)
	private VehicleReservation vehicleReservation;
	
	// ovde dodajte i vase rezervacije
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(nullable = true)
	private User usera;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FlightReservation getFlightReservation() {
		return flightReservation;
	}

	public void setFlightReservation(FlightReservation flightReservation) {
		this.flightReservation = flightReservation;
	}

	public HotelReservation getHotelReservation() {
		return hotelReservation;
	}

	public void setHotelReservation(HotelReservation hotelReservation) {
		this.hotelReservation = hotelReservation;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public VehicleReservation getVehicleReservation() {
		return vehicleReservation;
	}

	public void setVehicleReservation(VehicleReservation vehicleReservation) {
		this.vehicleReservation = vehicleReservation;
	}

	public User getUsera() {
		return usera;
	}

	public void setUsera(User usera) {
		this.usera = usera;
	}
	
	
	 



}
