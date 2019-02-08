package com.bff.flylivedrive.dto;

import java.util.Date;
import java.util.List;

public class RoomOnFastDTO {
	
	private Long id;
	private String roomName;
	private Date start_date;
	private Date end_date;
	private double dis_price;
	private double reg_price;
	private List<UslugaDTO> usluge;
	
	public RoomOnFastDTO() {
		
	}
	
	public RoomOnFastDTO(Long id, String roomName, Date start_date, Date end_date, double dis_price, double reg_price, List<UslugaDTO> usluge) {
		this.id = id;
		this.roomName = roomName;
		this.start_date = start_date;
		this.end_date = end_date;
		this.dis_price = dis_price;
		this.reg_price = reg_price;
		this.usluge = usluge;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
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

	public double getDis_price() {
		return dis_price;
	}

	public void setDis_price(double dis_price) {
		this.dis_price = dis_price;
	}

	public double getReg_price() {
		return reg_price;
	}

	public void setReg_price(double reg_price) {
		this.reg_price = reg_price;
	}

	public List<UslugaDTO> getUsluge() {
		return usluge;
	}

	public void setUsluge(List<UslugaDTO> usluge) {
		this.usluge = usluge;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
