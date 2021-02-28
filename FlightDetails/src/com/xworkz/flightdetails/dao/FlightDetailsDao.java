package com.xworkz.flightdetails.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.flightdetails.dto.FlightDTO;

public interface FlightDetailsDao {
	
	Connection getConnection() throws SQLException;
	
	boolean insertFlightRecord(FlightDTO flight);
	
	void insertListOfFlightRecord(ArrayList<FlightDTO> flight);

	void insertListOfFlightRecordUsingStmt(ArrayList<FlightDTO> flightList);

}
