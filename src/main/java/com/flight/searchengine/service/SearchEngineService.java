package com.flight.searchengine.service;




import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
