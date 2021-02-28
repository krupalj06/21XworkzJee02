package com.xworkz.flightdetails.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xworkz.flightdetails.dao.FlightDetailsDao;
import com.xworkz.flightdetails.dto.FlightDTO;

public class FlightDetailsDaoImpl implements FlightDetailsDao {

	@Override
	public Connection getConnection() throws SQLException {

		String url = "jdbc:mysql://localhost:3306/flightdetails";
		String username = "root";
		String password = "root123";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);

			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		throw new SQLException(); // Custom Exception

	}

	@Override
	public boolean insertFlightRecord(FlightDTO flight) {
		int result = 0;
		try {
			Connection conn = getConnection();

			String sqlQuery = "insert into flight values(? , ? , ? , ? , ? , ?)";
			// update flight set capacity = ? where flightName = ? ;

			PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);

			prepStmt.setString(6, flight.getDestination());
			prepStmt.setInt(1, flight.getFlightId());
			prepStmt.setString(2, flight.getFlightName());
			prepStmt.setInt(3, flight.getFuelCapacity());
			prepStmt.setDouble(4, flight.getArrivalTime());
			prepStmt.setString(5, flight.getSource());

			result = prepStmt.executeUpdate();
			if (result >= 1)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void insertListOfFlightRecord(ArrayList<FlightDTO> flightList) {
		
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			String sqlquery = "insert into flight values(?, ?, ?, ? ,? ,?); ";
			
			PreparedStatement prepStmt = conn.prepareStatement(sqlquery);
			
			for(FlightDTO flight : flightList) {
				
				prepStmt.setInt(1, flight.getFlightId());
				prepStmt.setString(2, flight.getFlightName());
				prepStmt.setInt(3, flight.getFuelCapacity());
				prepStmt.setDouble(4, flight.getArrivalTime());
				prepStmt.setString(5, flight.getSource());
				prepStmt.setString(6, flight.getDestination());
				
//				int result = prepStmt.executeUpdate();
//				System.out.println("result : " + result);
				
				prepStmt.addBatch();
			}
			
			int[] resultArr = prepStmt.executeBatch();
			
			System.out.println("Results are: ");
			for(int i : resultArr) {
				System.out.println(i);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void insertListOfFlightRecordUsingStmt(ArrayList<FlightDTO> flightList) {
		Connection conn = null;
		
		try {
		conn = getConnection();
		Statement stmt = conn.createStatement();
		
		for(FlightDTO flight :flightList) {
			String sqlquery = "insert into flight values("+flight.getFlightId()+", '"+flight.getFlightName()+"' , "+flight.getFuelCapacity()+", "+flight.getArrivalTime()+", "+flight.getSource()+", "+flight.getDestination()+"); ";
			stmt.addBatch(sqlquery);
		}
		int[] result = stmt.executeBatch();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
