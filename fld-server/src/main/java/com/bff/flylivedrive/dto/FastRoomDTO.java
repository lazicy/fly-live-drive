package com.bff.flylivedrive.dto;

import java.util.Date;

import com.bff.flylivedrive.model.FastRoom;

public class FastRoomDTO {
	
	private Long id;
	private Date start_date;
	private Date end_date;
	private double discount;
	
	public FastRoomDTO() {
		
	}
	
	public FastRoomDTO(Long id, Date start_date, Date end_date, double discount) {
		this.id = id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.discount = discount;
	}
	
	public FastRoomDTO(FastRoom fr) {
		this(fr.getId(), fr.getStart_date(), fr.getEnd_date(), fr.getDiscount());
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}
