package com.bff.flylivedrive.dto;

import java.util.Date;

import com.bff.flylivedrive.model.Interception;

public class InterceptionDTO {
	
	private long id;
	private Date takeOff;
	private Date landing;
	private int duration;
	private DestinationDTO destinationDTO;
	
	public InterceptionDTO() {
		
	}
	
	public InterceptionDTO(Interception i) {
		this(i.getId(), i.getTakeOff(), i.getLanding(), i.getDuration(), new DestinationDTO(i.getDestination()));
	}
	
	public InterceptionDTO(long id, Date takeOff, Date landing, int duration, DestinationDTO destinationDTO) {
		super();
		this.id = id;
		this.takeOff = takeOff;
		this.landing = landing;
		this.duration = duration;
		this.destinationDTO = destinationDTO;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getTakeOff() {
		return takeOff;
	}
	public void setTakeOff(Date takeOff) {
		this.takeOff = takeOff;
	}
	public Date getLanding() {
		return landing;
	}
	public void setLanding(Date landing) {
		this.landing = landing;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public DestinationDTO getDestinationDTO() {
		return destinationDTO;
	}

	public void setDestinationDTO(DestinationDTO destinationDTO) {
		this.destinationDTO = destinationDTO;
	}

	
	
	

}
