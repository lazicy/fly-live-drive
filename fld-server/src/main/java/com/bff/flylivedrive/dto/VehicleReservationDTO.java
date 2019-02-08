package com.bff.flylivedrive.dto;

import java.util.Date;

public class VehicleReservationDTO {
	
	private Long id;
	private Date pickUpDate;
	private Date dropOffDate;
	private FilijalaDTO pickUpLocation;
	private FilijalaDTO dropOffLocation;
	private int price;
	private VoziloDTO voziloDTO;
	private String username;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public Date getDropOffDate() {
		return dropOffDate;
	}
	public void setDropOffDate(Date dropOffDate) {
		this.dropOffDate = dropOffDate;
	}
	public FilijalaDTO getPickUpLocation() {
		return pickUpLocation;
	}
	public void setPickUpLocation(FilijalaDTO pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
	public FilijalaDTO getDropOffLocation() {
		return dropOffLocation;
	}
	public void setDropOffLocation(FilijalaDTO dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public VoziloDTO getVoziloDTO() {
		return voziloDTO;
	}
	public void setVoziloDTO(VoziloDTO voziloDTO) {
		this.voziloDTO = voziloDTO;
	}
	
	
	
}
