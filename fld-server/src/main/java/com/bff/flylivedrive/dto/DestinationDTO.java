package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Destination;

public class DestinationDTO {
	
	private Long id;
	private Long avioId;
	private CityDTO cityDTO;
	
	
	public DestinationDTO() {
		
	}
	
	public DestinationDTO(Long avioId, CityDTO cityDTO) {
		this.avioId = avioId;
		this.cityDTO = cityDTO;
	}
	
	public DestinationDTO(Destination d) {
		this(d.getId(), d.getAvio().getId(), new CityDTO(d.getCity()));
	}
	
	public DestinationDTO(Long id, Long avioId, CityDTO cityDTO) {
		super();
		this.id = id;
		this.avioId = avioId;
		this.cityDTO = cityDTO;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAvioId() {
		return avioId;
	}
	public void setAvioId(Long avioId) {
		this.avioId = avioId;
	}

	public CityDTO getCityDTO() {
		return cityDTO;
	}

	public void setCityDTO(CityDTO cityDTO) {
		this.cityDTO = cityDTO;
	}
	
	
	

}
