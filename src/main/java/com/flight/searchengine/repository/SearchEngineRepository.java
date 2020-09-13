package com.flight.searchengine.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flight.searchengine.entity.FlightDetails;

@Repository
public interface SearchEngineRepository extends CrudRepository<FlightDetails, Integer> {

	FlightDetails save(FlightDetails e);
	

	@Modifying
	@Query(value = "SELECT * FROM FLIGHT_DETAILS flights WHERE "
			+ " flights.source = :source AND flights.destination = :destination AND flights.departure >= :departure AND flights.price <= :price AND flights.duration <= :duration AND flights.flight_Name = :flight_Name AND flights.offercode = :offercode", 
			  nativeQuery = true)
	  List<FlightDetails>  getAvailableFlights(@Param("source") String source, @Param("destination") String destination, @Param("departure") Timestamp departure, @Param("price") int price,
			  @Param("duration") long duration, @Param("flight_Name") String flight_Name, @Param("offercode") String offercode);


	List<FlightDetails> findByStops(int stops);


	List<FlightDetails> findByDuration(long duration);
	
}

	
	

