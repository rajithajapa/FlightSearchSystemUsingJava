package com.vc.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vc.SearchRequest;
import com.vc.SearchResult;
import com.vc.common.FlightApp;

@Path("/flight/search")
public class JSONService {

	@GET
	@Path("/get/{from}/{to}")
	@Produces(MediaType.APPLICATION_JSON)
	public SearchResult getTrackInJSON(@PathParam("from") String from, @PathParam("to") String to) {

		SearchRequest request = new SearchRequest();
		request.setFrom(from);
		request.setTo(to);
		
		SearchResult result = new SearchResult();
		
//		List<Flight> flights = new ArrayList<Flight>();
//		
//		Flight f = new Flight();
//		f.setName("213123");
//		f.setTime("6 AM");
//		f.setFare(150);
//		f.setStops(2);
//		flights.add(f);
		
		result.setFrom("SFO to LA");
		FlightApp service = new FlightApp();
		result.setFlights(service.search());
		

		return result;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(SearchRequest track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();
		
	}
	
}