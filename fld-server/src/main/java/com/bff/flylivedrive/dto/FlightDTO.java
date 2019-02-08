package com.bff.flylivedrive.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.bff.flylivedrive.model.Flight;
import com.bff.flylivedrive.model.Interception;

public class FlightDTO {
	
	
	private Long id;
	private Date departureDate;
	private Date landingDate;
	private int totalDuration;
	private DestinationDTO departureDestination;
	private DestinationDTO landingDestination;
	private double price;
	private AvioDTO avioDTO;
	private List<InterceptionDTO> interceptionsDTO;
	private List<SeatDTO> seatsDTO;
	private int numberOfSeats;
	private int availableSeats;
	private int discountSeats;
	
	public FlightDTO() {
		
	}
	
	public FlightDTO(Flight f) {
		this(f.getId(), f.getDepartureDate(), f.getLandingDate(), f.getTotalDuration(),
				new DestinationDTO(f.getDepartureDestination()), new DestinationDTO(f.getLandingDestination()),
				f.getPrice(), new AvioDTO(f.getAvio()), f.getAvailableSeats(), f.getDiscountSeats());
		
		// mapping to interceptionsDTO list
		interceptionsDTO = new ArrayList<>();
		
		Iterator it = f.getInterceptions().iterator();
		
		while (it.hasNext()) {
			Interception i = (Interception)it.next();
			interceptionsDTO.add(new InterceptionDTO(i));
		}
		
		// mapping to seatsDTO 
		seatsDTO = new ArrayList<>();
		
		for (int i = 0; i < f.getSeats().size(); i++) {
			seatsDTO.add(new SeatDTO(f.getSeats().get(i)));
		}
		
		numberOfSeats = f.getSeats().size();
		
		
		
	}
	
	

	
	
	public FlightDTO(Long id, Date departureDate, Date landingDate, int totalDuration,
			DestinationDTO departureDest, DestinationDTO landingDest, double price, AvioDTO avioDTO, int availableSeats, int discountSeats) {
		super();
		this.id = id;
		this.departureDate = departureDate;
		this.landingDate = landingDate;
		this.totalDuration = totalDuration;
		this.departureDestination = departureDest;
		this.landingDestination = landingDest;
		this.price = price;
		this.avioDTO = avioDTO;
		this.availableSeats = availableSeats;
		this.discountSeats = discountSeats;
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getLandingDate() {
		return landingDate;
	}
	public void setLandingDate(Date landingDate) {
		this.landingDate = landingDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public AvioDTO getAvioDTO() {
		return avioDTO;
	}
	public void setAvioDTO(AvioDTO avioDTO) {
		this.avioDTO = avioDTO;
	}

	public int getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(int totalDuration) {
		this.totalDuration = totalDuration;
	}


	public List<InterceptionDTO> getInterceptionsDTO() {
		return interceptionsDTO;
	}

	public void setInterceptionsDTO(List<InterceptionDTO> interceptionsDTO) {
		this.interceptionsDTO = interceptionsDTO;
	}

	public DestinationDTO getDepartureDestination() {
		return departureDestination;
	}

	public void setDepartureDestination(DestinationDTO departureDestination) {
		this.departureDestination = departureDestination;
	}

	public DestinationDTO getLandingDestination() {
		return landingDestination;
	}

	public void setLandingDestination(DestinationDTO landingDestination) {
		this.landingDestination = landingDestination;
	}



	public List<SeatDTO> getSeatsDTO() {
		return seatsDTO;
	}

	public void setSeatsDTO(List<SeatDTO> seatsDTO) {
		this.seatsDTO = seatsDTO;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getDiscountSeats() {
		return discountSeats;
	}

	public void setDiscountSeats(int discountSeats) {
		this.discountSeats = discountSeats;
	}
	
	
	
	
	
	
	
	

	
	


	
}
