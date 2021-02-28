package com.xworkz.flightdetails.service;

import com.xworkz.flightdetails.dao.impl.FlightTicketDaoImpl;
import com.xworkz.flightdetails.dto.FlightDTO;
import com.xworkz.flightdetails.dto.FlightTicketDTO;

public class FlightTransactionTester {

	public static void main(String[] args) {
		FlightTicketDaoImpl dao = new FlightTicketDaoImpl();
		
//		Senario1:
//		FlightDTO flight = new FlightDTO(15, "GoAir", 100, 6.30, "Delhi", "Banglore");
//		FlightTicketDTO ticket = new FlightTicketDTO(41, "L27", 2500.00, 2, "Economic");
//		
//		dao.flightTransaction(flight, ticket);
		
		FlightDTO flight = new FlightDTO(16, "JetAirways", 120, 5.30, "Kolkata", "Pune");
		FlightTicketDTO ticket = new FlightTicketDTO(42, "W78", 8000.00, 1, "Business");
		
		dao.flightTransaction(flight, ticket);
		
		
		
	}

}
