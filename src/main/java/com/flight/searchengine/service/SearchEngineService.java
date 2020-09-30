package com.flight.searchengine.service;




import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.flight.searchengine.entity.FlightDetails;
import com.flight.searchengine.repository.SearchEngineRepository;
@Service
public class SearchEngineService{

	@Autowired  
	SearchEngineRepository repo;

	String line="";

	public void insertDataFromCsv() {
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
				e.setStops(Integer.parseInt(data[7]));
				e.setDuration(Long.parseLong(data[8]));
				e.setPrice(Integer.parseInt(data[9]));
				repo.save(e);
			}
		}catch(IOException exp){

			exp.printStackTrace();
		}
	}
		
		
		
		public List<FlightDetails> getAvailableFlights(String source,String destination,Timestamp departure, int stops, int price,long duration,String flightName,String offercode){
	        return repo.findAll(new Specification<FlightDetails>() {
	            @Override
	            public Predicate toPredicate(Root<FlightDetails> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
	                List<Predicate> predicates = new ArrayList<>();
	                if(source!=null) {
	                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("source"), source)));
	                }
	                if(destination!=null) {
	                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("destination"), destination)));
	                }
	                if(departure!=null) {
	                    predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("departure"), departure)));
	                }
	                    predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("stops"), stops)));
	                if(price!=0){
	                    predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("price"), price)));
	                }
	                if(duration!=0){
	                    predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("duration"), duration)));
	                }
	                if(flightName!=null) {
	                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("flightName"), flightName)));
	                }
	                if(offercode!=null) {
	                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("offercode"), offercode)));
	                }
	                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	            }
	        });
	    }

	

}
