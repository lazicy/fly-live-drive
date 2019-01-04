package com.bff.flylivedrive.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("HOTEL_ADMIN")
public class HotelAdmin extends User {
	
	public HotelAdmin() {
		
	}
	
	public HotelAdmin(User user) {
		super(user);
	}
}
