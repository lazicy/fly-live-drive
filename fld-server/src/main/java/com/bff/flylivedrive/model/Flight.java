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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="departureDate", nullable=false)
	private Date departureDate;
	
	@Column(name="landingDate", nullable=false)
	private Date landingDate;
	
	// in minutes
	@Column(name="totalDuration", nullable = false)
	private int totalDuration;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private City departureCity;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private City landingCity;
	
	@Column(name="price", nullable=false)
	private double price;
	
	@Column(name="numberOfInterceptions", nullable = false)
	private int numberOfInterceptions;
	
	@OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Interception> interceptions = new HashSet<Interception>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Avio avio;
	
	


	public int getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(int totalDuration) {
		this.totalDuration = totalDuration;
	}

	public City getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(City departureCity) {
		this.departureCity = departureCity;
	}

	public City getLandingCity() {
		return landingCity;
	}

	public void setLandingCity(City landingCity) {
		this.landingCity = landingCity;
	}

	public int getNumberOfInterceptions() {
		return numberOfInterceptions;
	}

	public void setNumberOfInterceptions(int numberOfInterceptions) {
		this.numberOfInterceptions = numberOfInterceptions;
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
	
	
	
}
