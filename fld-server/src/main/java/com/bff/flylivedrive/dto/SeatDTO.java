package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Seat;

public class SeatDTO {
	
	private Long id;
	private boolean reserved;
	private int row;
	private String place;
	private double discount;
	private boolean deleted;
	
	public SeatDTO() {
		
	}
	
	public SeatDTO(Seat s) {
		this(s.getId(), s.isReserved(), s.getRow(), s.getPlace(), s.getDiscount(), s.isDeleted());
	}
	
	public SeatDTO(Long id, boolean reserved, int row, String place, double discount, boolean deleted) {
		super();
		this.id = id;
		this.reserved = reserved;
		this.row = row;
		this.place = place;
		this.discount = discount;
		this.deleted = deleted;
	}
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	



}
