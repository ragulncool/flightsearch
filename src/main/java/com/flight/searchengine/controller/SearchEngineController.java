package com.flight.searchengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.searchengine.entity.FlightDetails;
import com.flight.searchengine.repository.SearchEngineRepository;
import com.flight.searchengine.service.SearchEngineService;
import com.flight.searchengine.service.SearchEngineServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SearchEngineController {
	
	@Autowired
	private SearchEngineRepository repo;
	
	@Autowired
	private SearchEngineService service;

	@RequestMapping("/welcome")
	public String msg(){
		return "Hello World";
	}
	
	
	@RequestMapping("/delete1")
	public String delete1(){
			repo.deleteById(5) ;
			return	"DELETED";
	}
	
	@RequestMapping("/csvinsert")
	public String csvinsert(){
			service.insertDataFromCsv();
			return	"CSV INSERTED";
	}
	
	@RequestMapping("/fetchFlight")
	public List<FlightDetails> fetchFlight(@RequestParam FlightDetails request){
		//List<FlightDetails> a= repo.getAvailableFlights(request.getDeparture().toLocalDateTime(), request.getArrival().toLocalDateTime(), request.getSource(), request.getDestination()) ;
        System.out.println(request);
		return null;
	}
}
