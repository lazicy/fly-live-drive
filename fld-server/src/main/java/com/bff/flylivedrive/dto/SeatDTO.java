package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Seat;

public class SeatDTO {
	
	private Long id;
	private boolean reserved;
	private int row;
	private String place;
	
	public SeatDTO() {
		
	}
	
	public SeatDTO(Seat s) {
		this(s.getId(), s.isReserved(), s.getRow(), s.getPlace());
	}
	
	public SeatDTO(Long id, boolean reserved, int row, String place) {
		super();
		this.id = id;
		this.row = row;
		this.place = place;
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



}
