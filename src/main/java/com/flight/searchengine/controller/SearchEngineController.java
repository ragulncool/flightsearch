package com.flight.searchengine.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.searchengine.entity.FlightDetails;
import com.flight.searchengine.repository.SearchEngineRepository;
import com.flight.searchengine.service.SearchEngineService;
//import com.flight.searchengine.service.SearchEngineServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SearchEngineController {
	
	@Autowired
	private SearchEngineRepository repo;
	
	@Autowired
	private SearchEngineService service;

	@RequestMapping("/csvinsert")
	public String csvinsert(){
			service.insertDataFromCsv();
			return	"CSV INSERTED";
	}
	
//	@RequestMapping("/fetchFlight")
////	public List<FlightDetails> fetchFlight(@RequestBody FlightDetails request){
////		List<FlightDetails> a= repo.getAvailableFlights( request.getSource(), request.getDestination()) ;
//	public List<FlightDetails> fetchFlight(@RequestParam String source, @RequestParam String destination, @RequestParam Timestamp departure, @RequestParam(required=false, defaultValue="2500") int price, @RequestParam(required=false, defaultValue="4") long duration, @RequestParam(required=false) String flightName, @RequestParam(required=false) String offercode){ 
//		//List<FlightDetails> flightDetails= repo.getAvailableFlights(source, destination, departure, price, duration, flightName, offercode) ;
//		List<FlightDetails> flightDetails= service.getAvailableFlights(source, offercode) ;
//
//		return flightDetails;
//	}
	
	@RequestMapping("/fetchFlight")
	public List<FlightDetails> fetchFlight(@RequestParam String source, @RequestParam String destination, @RequestParam Timestamp departure, @RequestParam(required=false, defaultValue="0") int stops, @RequestParam(required=false, defaultValue="0") int price, @RequestParam(required=false, defaultValue="0") long duration, @RequestParam(required=false) String flightName, @RequestParam(required=false) String offercode){ 
		List<FlightDetails> flightDetails= service.getAvailableFlights(source, destination, departure, stops, price, duration, flightName, offercode) ;
		return flightDetails;
	}
	
	
//	@RequestMapping("/fetchByStops")
//	public List<FlightDetails> fetchByStops(@RequestParam int stops){
//		List<FlightDetails> a= repo.findByStops( stops) ;
//		return a;
//	}
//	
//
//	@RequestMapping("/fetchByDuration")
//	public List<FlightDetails> fetchByDuration(@RequestParam long duration){
//		List<FlightDetails> a= repo.findByDuration( duration) ;
//		return a;
//		
//	}
}
