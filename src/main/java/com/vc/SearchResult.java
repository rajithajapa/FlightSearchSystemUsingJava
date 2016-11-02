package com.vc;

import java.util.List;
import com.vc.common.Flight;

public class SearchResult {
	private String from;
	private List<Flight> flights;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	 
}
