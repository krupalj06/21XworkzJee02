package com.xworkz.flightdetails.service;

import java.util.ArrayList;

import com.xworkz.flightdetails.dao.impl.FlightDetailsDaoImpl;
import com.xworkz.flightdetails.dto.FlightDTO;

public class InsertListOfFlightsTester {

	public static void main(String[] args) {
		
		FlightDetailsDaoImpl flightDao = new FlightDetailsDaoImpl();
		
		ArrayList<FlightDTO> flightList = new ArrayList<FlightDTO>();
		flightList.add(new FlightDTO(2, "Sahara", 150, 6.50 , "pune", "mumbai"));
		flightList.add(new FlightDTO(3, "Kingfisher", 130, 3.20 , "bangalore", "chennai"));
		flightList.add(new FlightDTO(4, "GOAir", 100, 5.00 , "pune", "Kolkata"));
		
		flightDao.insertListOfFlightRecord(flightList);

	}

}
