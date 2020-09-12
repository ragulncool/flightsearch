package com.flight.searchengine.service;




import java.util.List;

import com.flight.searchengine.entity.FlightDetails;

public interface SearchEngineService{

	public void insertDataToDB(FlightDetails e);

	public void insertDataFromCsv();
	
	public List<FlightDetails> fetchFlightDataFlightDetails(FlightDetails details);
	
}
