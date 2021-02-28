package com.xworkz.flightdetails.dao;

import com.xworkz.flightdetails.dto.FlightDTO;
import com.xworkz.flightdetails.dto.FlightTicketDTO;

public interface FlightTicketDao {
	
	void flightTransaction(FlightDTO flight, FlightTicketDTO ticket);

}
