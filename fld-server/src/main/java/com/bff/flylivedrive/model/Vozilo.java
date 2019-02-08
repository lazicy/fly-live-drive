package com.bff.flylivedrive.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.bff.flylivedrive.dto.VoziloDTO;

@Entity
public class Vozilo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "model", nullable = false)
	String model;
	
	@Column(name = "brand", nullable = false)
	String brand;
	
	@Column(name = "production_year", nullable = false)
	String productionYear;
	
	@Column(name = "number_of_seats", nullable = false)
	int numberOfSeats;
	
	@Column(name = "type", nullable = false)
	String type;
	
	@Column(name = "price_per_day", nullable = false)
	int pricePerDay;
	
	//jedno vozilo vezano je samo za jednu filjalu
	@ManyToOne(fetch = FetchType.EAGER)
	private Filijala filijala;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private FastResVehicle fastRes;
	
	public FastResVehicle getFastRes() {
		return fastRes;
	}

	public void setFastRes(FastResVehicle fastRes) {
		this.fastRes = fastRes;
	}

	@OneToOne(mappedBy = "vozilo",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private VehicleReservation vehicleReservation;
	
	
	public Vozilo() {
		
	}

	public Vozilo(Long id, String model, String brand, String productionYear, int numberOfSeats, String type, int price) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.productionYear = productionYear;
		this.numberOfSeats = numberOfSeats;
		this.type = type;
		this.pricePerDay = price;
	}

	public Vozilo(VoziloDTO voziloDTO) {
		this(voziloDTO.getId(),voziloDTO.getModel(), voziloDTO.getBrand(),voziloDTO.getProductionYear(),voziloDTO.getNumberOfSeats(),voziloDTO.getType(),voziloDTO.getPricePerDay());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Filijala getFilijala() {
		return filijala;
	}

	public void setFilijala(Filijala filijala) {
		this.filijala = filijala;
	}

	public String getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public VehicleReservation getVehicleReservation() {
		return vehicleReservation;
	}

	public void setVehicleReservation(VehicleReservation vehicleReservation) {
		this.vehicleReservation = vehicleReservation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	
}
