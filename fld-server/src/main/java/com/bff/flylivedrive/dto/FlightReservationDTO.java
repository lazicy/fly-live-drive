package com.bff.flylivedrive.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bff.flylivedrive.model.Flight;
import com.bff.flylivedrive.model.FlightReservation;
import com.bff.flylivedrive.model.Passenger;

public class FlightReservationDTO {

	
	private Long id;
	
	private String tripType;
	
	private Date reservationDate;
	
	private Long departureFlightId;
	
	private Long returnFlightId;
	
	private String username;
	
	private double totalPrice;
	
	private List<SeatDTO> departureSeatsDTO;

	private List<SeatDTO> returnSeatsDTO;
	
	public ArrayList<Passenger> passengers;

	public FlightReservationDTO() {
		
	}
	
	public FlightReservationDTO(FlightReservation fr) {
		this(fr.getId(), fr.getTripType(), fr.getReservationDate(), fr.getDepartureFlight().getId(), fr.getReturnFlight().getId(),
				fr.getUsername(), fr.getTotalPrice());
		
		
	}
	
	public FlightReservationDTO(FlightReservation fr, Long id) {
		this(fr.getId(), fr.getTripType(), fr.getReservationDate(), fr.getDepartureFlight().getId(), id,
				fr.getUsername(), fr.getTotalPrice());
	}
	
	public FlightReservationDTO(Long id, String tripType, Date reservationDate, Long departureFlightId,
			Long returnFlightId, String username, double totalPrice) {
		super();
		this.id = id;
		this.tripType = tripType;
		this.reservationDate = reservationDate;
		this.departureFlightId = departureFlightId;
		this.returnFlightId = returnFlightId;
		this.username = username;
		this.totalPrice = totalPrice;
	}



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

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}



	public Long getDepartureFlightId() {
		return departureFlightId;
	}

	public void setDepartureFlightId(Long departureFlightId) {
		this.departureFlightId = departureFlightId;
	}

	public Long getReturnFlightId() {
		return returnFlightId;
	}

	public void setReturnFlightId(Long returnFlightId) {
		this.returnFlightId = returnFlightId;
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
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

	public List<SeatDTO> getDepartureSeatsDTO() {
		return departureSeatsDTO;
	}

	public void setDepartureSeatsDTO(List<SeatDTO> departureSeatsDTO) {
		this.departureSeatsDTO = departureSeatsDTO;
	}

	public List<SeatDTO> getReturnSeatsDTO() {
		return returnSeatsDTO;
	}

	public void setReturnSeatsDTO(List<SeatDTO> returnSeatsDTO) {
		this.returnSeatsDTO = returnSeatsDTO;
	}
	
	
	
	
}
