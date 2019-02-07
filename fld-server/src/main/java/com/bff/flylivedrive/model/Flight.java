package com.bff.flylivedrive.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="departureDate", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureDate;
	
	@Column(name="landingDate", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date landingDate;
	
	// in minutes
	@Column(name="totalDuration", nullable = false)
	private int totalDuration;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Destination departureDestination;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Destination landingDestination;
	
	@Column(name="price", nullable=false)
	private double price;
	
	@Column(name="availableSeats", nullable=false)
	private int availableSeats;
	
	@OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Interception> interceptions = new HashSet<Interception>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Avio avio;
	
	@OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Seat> seats = new ArrayList<>();
	
	


	public int getTotalDuration() {
		
		return totalDuration;
	}

	public void setTotalDuration(int totalDuration) {
		this.totalDuration = totalDuration;
	}



	public Destination getDepartureDestination() {
		return departureDestination;
	}

	public void setDepartureDestination(Destination departureDestination) {
		this.departureDestination = departureDestination;
	}

	public Destination getLandingDestination() {
		return landingDestination;
	}

	public void setLandingDestination(Destination landingDestination) {
		this.landingDestination = landingDestination;
	}

	public Set<Interception> getInterceptions() {
		return interceptions;
	}

	public void setInterceptions(Set<Interception> interceptions) {
		this.interceptions = interceptions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getLandingDate() {
		return landingDate;
	}

	public void setLandingDate(Date landingDate) {
		this.landingDate = landingDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Avio getAvio() {
		return avio;
	}

	public void setAvio(Avio avio) {
		this.avio = avio;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	

	
	
	
}
