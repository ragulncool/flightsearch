package com.flight.searchengine.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flight.searchengine.entity.FlightDetails;
import com.flight.searchengine.repository.SearchEngineRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchEngineServiceImpl implements SearchEngineService{

	private static final List<FlightDetails> FlightDetails = null;
	@Autowired
	private final SearchEngineRepository repo;
	
	@Override
	public void insertDataToDB(FlightDetails e) {
	
	}
	
	String line="";
	
	@Override
	public void insertDataFromCsv(){
		FlightDetails e= new FlightDetails();
		try{
			BufferedReader br=new BufferedReader(new FileReader("src/main/resources/flightdetails6.csv"));
			while((line=br.readLine())!=null){
				System.out.println("Line"+line);
				String [] data=line.split(",");
				e.setFlightName(data[0]);
	e.setSource(data[1]);
	e.setDestination(data[2]);
	
	 
	   Timestamp timestampdep = Timestamp.valueOf(data[3]);
		e.setDeparture(timestampdep);
		 Timestamp timestamparr = Timestamp.valueOf(data[4]);

		e.setArrival(timestamparr);
		e.setOffercode(data[5]);
		e.setId(Integer.parseInt(data[6]));
				repo.save(e);
			}
		}catch(IOException exp){
			
			exp.printStackTrace();
		}
		
	

}
	
	@Override
	public List<FlightDetails> fetchFlightDataFlightDetails(FlightDetails details) {
		LocalDateTime departure = details.getDeparture().toLocalDateTime();
		LocalDateTime arrival = details.getArrival().toLocalDateTime();
		String source = details.getSource();
		String destination = details.getDestination();
       List<FlightDetails> flightdetails = repo.getAvailableFlights(departure, source, destination);
       return flightdetails;	
	}




}
