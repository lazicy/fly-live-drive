package com.bff.flylivedrive.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import org.assertj.core.util.DateUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy=SINGLE_TABLE) //ovom anotacijom se naglasava tip mapiranja "jedna tabela po hijerarhiji"
@DiscriminatorColumn(name="type", discriminatorType=STRING) //ovom anotacijom se navodi diskriminatorska kolona
public class User implements UserDetails{
	
	@Id
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "firstname", nullable = false)
	private String firstname;
	
	@Column(name = "lastname", nullable = false)
	private String lastname;
	
	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name="bonus_points", nullable = false)
	private int bonus_points;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<HotelReservation> hotelRes = new HashSet<>();
	
	@Column(name = "active", nullable = false)
	private boolean active = false; //inicijalno je uvek false prilikom registracije, menja se nakon potvrde mejlom
	
	@Column(name="firstLog", nullable = false)
	private boolean firstLog = false;
	
	@Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;
	
	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable(name = "user_authority",
	            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "username"),
	            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	private List<Authority> authorities;
	 
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	private GlobalReservation globalReservation;
	 
	public User() {
		super();
	}
	
	public User(String username, String password, String firstname, String lastname, String email, String city, int bonus_points,
			boolean active, Timestamp lastPasswordResetDate, List<Authority> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.city = city;
		this.bonus_points = bonus_points;
		this.active = active;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.authorities = authorities;
	}
	
	public User(User user) {
		this(user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getCity(), user.getBonus_points(), user.isActive(), user.getLastPasswordResetDate(), (List<Authority>) user.getAuthorities());
	}
	
	public Timestamp getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		//Timestamp now = new Timestamp(DateUtil.now().getTime());
        //this.setLastPasswordResetDate( now );
        this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBonus_points() {
		return bonus_points;
	}

	public void setBonus_points(int bonus_points) {
		this.bonus_points = bonus_points;
	}

	public Set<HotelReservation> getHotelRes() {
		return hotelRes;
	}

	public void setHotelRes(Set<HotelReservation> hotelRes) {
		this.hotelRes = hotelRes;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	 
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean isFirstLog() {
		return firstLog;
	}

	public void setFirstLog(boolean firstLog) {
		this.firstLog = firstLog;
	}
	
	

	public GlobalReservation getGlobalReservation() {
		return globalReservation;
	}

	public void setGlobalReservation(GlobalReservation globalReservation) {
		this.globalReservation = globalReservation;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

}
