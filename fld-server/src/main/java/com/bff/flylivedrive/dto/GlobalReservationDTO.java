package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.FlightReservation;
import com.bff.flylivedrive.model.GlobalReservation;

public class GlobalReservationDTO {
	
	private Long id;
	private boolean active;
	private FlightReservationDTO frDTO;
	private VehicleReservationDTO vDTO;
	private String username;
	
	private GlobalReservationDTO() {
		
	}
	
	
	public GlobalReservationDTO(GlobalReservation gr) {
		this(gr.getId(), gr.isActive());
		
		FlightReservation fr = gr.getFlightReservation();
		
		String tripType = fr.getTripType();
		
		FlightReservationDTO frDTO;
		if (tripType.equals("round")) {
			frDTO = new FlightReservationDTO(fr);
		} else {
			frDTO = new FlightReservationDTO(fr, new Long(-1));
			
		}
		
		frDTO.setBonusPointsEarned(0);
		
		this.setFrDTO(frDTO);
		
	}
	
	
	public GlobalReservationDTO(Long id, boolean active) {
		super();
		this.id = id;
		this.active = active;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public FlightReservationDTO getFrDTO() {
		return frDTO;
	}
	public void setFrDTO(FlightReservationDTO frDTO) {
		this.frDTO = frDTO;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	public VehicleReservationDTO getvDTO() {
		return vDTO;
	}


	public void setvDTO(VehicleReservationDTO vDTO) {
		this.vDTO = vDTO;
	}
	

}
