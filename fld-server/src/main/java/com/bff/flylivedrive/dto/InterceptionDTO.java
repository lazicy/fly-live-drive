package com.bff.flylivedrive.dto;

import java.util.Date;

import com.bff.flylivedrive.model.Interception;

public class InterceptionDTO {
	
	private long id;
	private int duration;
	private DestinationDTO destinationDTO;
	
	public InterceptionDTO() {
		
	}
	
	public InterceptionDTO(Interception i) {
		this(i.getId(), i.getDuration(), new DestinationDTO(i.getDestination()));
	}
	
	public InterceptionDTO(long id, int duration, DestinationDTO destinationDTO) {
		super();
		this.id = id;
		this.duration = duration;
		this.destinationDTO = destinationDTO;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
