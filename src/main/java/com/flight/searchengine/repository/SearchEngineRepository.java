package com.flight.searchengine.repository;

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
	@Query(value = "SELECT flights FROM FLIGHT_DETAILS flights WHERE flights.departure >= departure AND flights.arrival <= arrival"
			+ "AND flights.source = source AND flights.destination = destination", 
			  nativeQuery = true)
	  List<FlightDetails>  getAvailableFlights(@Param("departure") LocalDateTime departure, @Param("source") String source, @Param("destination") String destination);   
	
	
	
	
}

	
	

