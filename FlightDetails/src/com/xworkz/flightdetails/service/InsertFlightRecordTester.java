package com.xworkz.flightdetails.service;

import com.xworkz.flightdetails.dao.FlightDetailsDao;
import com.xworkz.flightdetails.dao.impl.FlightDetailsDaoImpl;
import com.xworkz.flightdetails.dto.FlightDTO;

public class InsertFlightRecordTester {
	
	public static void main(String[] args) {
		
		FlightDetailsDao flightdao = new FlightDetailsDaoImpl();
		
		FlightDTO flight = new FlightDTO(1, "Indigo", 100 , 5.00 , "Banglore", "Delhi");
		
		boolean result = flightdao.insertFlightRecord(flight);
		
		System.out.println("The flight details are inserted ? "+ result);
		
	}

}
