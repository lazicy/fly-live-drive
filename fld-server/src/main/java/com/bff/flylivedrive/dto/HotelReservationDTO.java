package com.bff.flylivedrive.dto;

import java.util.Date;

import com.bff.flylivedrive.model.HotelReservation;

public class HotelReservationDTO {
	
	private Long id;
	private Date reservation_date;
	private Date arrival_date;
	private Date departure_date;
	private int no_nights;
	private double discount;
	private double total_price;
	private boolean fastRez;
	
	public HotelReservationDTO() {
		
	}
	
	public HotelReservationDTO(HotelReservation h) {
		this(h.getId(), h.getReservation_date(), h.getArrival_date(), h.getDeparture_date(), h.getNo_nights(), h.getDiscount(), h.getTotal_price(), h.isFastRez());
		}

	public HotelReservationDTO(Long id, Date reservation_date, Date arrival_date, Date departure_date, int no_nights, double discount, double total_price, boolean fastRez) {
		super();
		this.id = id;
		this.reservation_date = reservation_date;
		this.arrival_date = arrival_date;
		this.departure_date = departure_date;
		this.no_nights = no_nights;
		this.discount = discount;
		this.total_price = total_price;
		this.fastRez = fastRez;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(Date reservation_date) {
		this.reservation_date = reservation_date;
	}

	public Date getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}

	public Date getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}

	public int getNo_nights() {
		return no_nights;
	}

	public void setNo_nights(int no_nights) {
		this.no_nights = no_nights;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public boolean isFastRez() {
		return fastRez;
	}

	public void setFastRez(boolean fastRez) {
		this.fastRez = fastRez;
	}
	
}
