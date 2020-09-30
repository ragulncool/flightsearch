package com.flight.searchengine.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
@Entity
@Table(name= "FLIGHT_DETAILS") 
public class FlightDetails {

	@Id
	@Column
	private int id;
		
	@Column(name= "flight_name") 
    private String flightName;
	
	@Column
	private String source;
	
	@Column
	private String destination;
	
	@Column
	private Timestamp departure;
	
	@Column
	private Timestamp arrival;
	
	@Column
	private String offercode;
	
	@Column
	private int stops;
	
	@Column
	private long duration;
	
	@Column
	private int price;
}
