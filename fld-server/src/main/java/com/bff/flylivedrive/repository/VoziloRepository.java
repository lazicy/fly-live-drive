package com.bff.flylivedrive.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bff.flylivedrive.model.RentAdmin;
import com.bff.flylivedrive.model.Vozilo;
public interface VoziloRepository extends JpaRepository<Vozilo, Long>, JpaSpecificationExecutor<Vozilo> {
	
	Vozilo findOneById(Long id);
	
	//pretraga bez datuma - slobodna vozila
	@Query("select vozilo from Vozilo vozilo, VehicleReservation vres,Filijala filijala where vozilo.id != vres.vozilo.id and filijala.city.id = :city"
			+ " and vozilo.numberOfSeats = :seats and vozilo.filijala.id = filijala.id")
	public List<Vozilo> getNotResVehicles(@Param("city") Long city,@Param("seats") int seats);
	
	@Query("select vozilo from Vozilo vozilo, VehicleReservation vres,Filijala filijala where vozilo.id != vres.vozilo.id and filijala.city.id = :city"
			+ " and vozilo.filijala.id = filijala.id")
	public List<Vozilo> getNotResVehicles(@Param("city") Long city);
	
	
	//pretraga sa datumom
	@Query("select vozilo from Filijala filijala,Vozilo vozilo, VehicleReservation vres,FastResVehicle fr where vozilo.id = vres.vozilo.id and filijala.city.id = :city"
			+ " and :pickUpDate not between vres.pickUpDate and vres.dropOffDate and :dropOffDate not between vres.pickUpDate and vres.dropOffDate"
			+ " and vozilo.numberOfSeats=:seats and vozilo.filijala.id = filijala.id")
	public List<Vozilo> getResVehicles(@Param("pickUpDate") Date pickUpDate,@Param("dropOffDate") Date dropOffDate,@Param("city") Long city, @Param("seats") int seats);
	
	@Query("select vozilo from Filijala filijala,Vozilo vozilo, VehicleReservation vres where vozilo.id = vres.vozilo.id and filijala.city.id = :city"
			+ " and :pickUpDate not between vres.pickUpDate and vres.dropOffDate and :dropOffDate not between vres.pickUpDate and vres.dropOffDate"
			+ " and vozilo.filijala.id = filijala.id")
	public List<Vozilo> getResVehicles(@Param("pickUpDate") Date pickUpDate,@Param("dropOffDate") Date dropOffDate,@Param("city") Long city);
	
	@Query("select v from Vozilo v, Filijala f where v.filijala.id = f.id and f.city.id = :id")
	public List<Vozilo> findAllByCityId(@Param("id") Long id);

	@Query("select v from Vozilo v, FastResVehicle fr where v.filijala.servis.id = :id and v.fastRes.id = fr.id")
	public List<Vozilo> findAllFastRes(@Param("id") Long id);
	
	@Query("select v from Vozilo v, FastResVehicle fr where v.fastRes.id = fr.id and :start between v.fastRes.startDate and v.fastRes.endDate"
			+ " and :end between v.fastRes.startDate and v.fastRes.endDate")
	public List<Vozilo> findFast(@Param("start") Date start, @Param("end") Date end);
}
