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

@Entity
public class HotelReservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Date reservation_date;
	
	@Column
	private Date arrival_date;
	
	@Column
	private Date departure_date;

	@Column
	private int no_nights;
	
	@Column
	private double discount;

	@Column
	private double total_price;

	@Column
	private boolean brza;
	
	@Column
	private boolean aktivirana;
	
//	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
//	private Set<Usluga> usluge = new HashSet<Usluga>();
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Room Room;
	
	@ManyToOne()
	private User user;
	
	
}
