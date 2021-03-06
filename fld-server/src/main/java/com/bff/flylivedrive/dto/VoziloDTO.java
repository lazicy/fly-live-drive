package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.FastResVehicle;
import com.bff.flylivedrive.model.Vozilo;

public class VoziloDTO {
	
	private Long id;
	private String model;
	private String brand;
	private String productionYear;
	private int numberOfSeats;
	private String type;
	private int pricePerDay;
	private FilijalaDTO filijalaDTO;
	private FastResVehicleDTO frDTO;
	
	public VoziloDTO() {
		
	}
	
	
	public VoziloDTO(Long id, String model, String brand, String productionYear, int numberOfSeats, String type, int price, FilijalaDTO filijalaDTO) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.productionYear = productionYear;
		this.numberOfSeats = numberOfSeats;
		this.type = type;
		this.setPricePerDay(price);
		this.filijalaDTO = filijalaDTO;
	}

	public VoziloDTO(Vozilo vozilo) {
		this(vozilo.getId(), vozilo.getModel(), vozilo.getBrand(),vozilo.getProductionYear(),vozilo.getNumberOfSeats(),vozilo.getType(),vozilo.getPricePerDay(), new FilijalaDTO(vozilo.getFilijala()));
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


	public FilijalaDTO getFilijalaDTO() {
		return filijalaDTO;
	}


	public void setFilijalaDTO(FilijalaDTO filijalaDTO) {
		this.filijalaDTO = filijalaDTO;
	}


	public FastResVehicleDTO getFrDTO() {
		return frDTO;
	}


	public void setFrDTO(FastResVehicleDTO frDTO) {
		this.frDTO = frDTO;
	}

}
