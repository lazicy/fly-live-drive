package com.bff.flylivedrive.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class VehicleReservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Filijala pickUpLocation;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Filijala dropOffLocation;
	
	@Column(name = "pick_up_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date pickUpDate;
	
	@Column(name = "drop_off_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date dropOffDate;
	
	@Column(name = "price", nullable = false)
	int price;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	City city;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	User user;
	
	@OneToOne
	Vozilo vozilo;
	
	public VehicleReservation() {
		
	}
	
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

	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public Vozilo getVozilo() {
		return vozilo;
	}

	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}

	public Filijala getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(Filijala pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public Filijala getDropOffLocation() {
		return dropOffLocation;
	}

	public void setDropOffLocation(Filijala dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
