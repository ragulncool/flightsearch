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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Timestamp getDeparture() {
		return departure;
	}

	public void setDeparture(Timestamp departure) {
		this.departure = departure;
	}

	public Timestamp getArrival() {
		return arrival;
	}

	public void setArrival(Timestamp arrival) {
		this.arrival = arrival;
	}

	public String getOffercode() {
		return offercode;
	}

	public void setOffercode(String offercode) {
		this.offercode = offercode;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
	
}
