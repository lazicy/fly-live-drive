package com.bff.flylivedrive.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HotelReservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="reservation_date")
	@Temporal(TemporalType.DATE)
	private Date reservation_date;
	
	@Column(name="arrival_date")
	@Temporal(TemporalType.DATE)
	private Date arrival_date;
	
	@Column(name="departure_date")
	@Temporal(TemporalType.DATE)
	private Date departure_date;

	@Column(name="no_nights")
	private int no_nights;
	
	@Column(name="discount")
	private double discount;

	@Column(name="total_price")
	private double total_price;

	@Column(name="fastRez")
	private boolean fastRez;
	
	@Column(name="active")
	private boolean active;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "hotelRes_services",
    joinColumns = @JoinColumn(name = "hotelRes_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id"))
	private Set<Usluga> usluge = new HashSet<Usluga>();
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Room room;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Usluga> getUsluge() {
		return usluge;
	}

	public void setUsluge(Set<Usluga> usluge) {
		this.usluge = usluge;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
