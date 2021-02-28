package com.xworkz.flightdetails.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.flightdetails.dao.FlightTicketDao;
import com.xworkz.flightdetails.dto.FlightDTO;
import com.xworkz.flightdetails.dto.FlightTicketDTO;

public class FlightTicketDaoImpl implements FlightTicketDao {
	
	@Override
	public void flightTransaction(FlightDTO flight, FlightTicketDTO ticket) {
		
		FlightDetailsDaoImpl dao = new FlightDetailsDaoImpl();
		Connection conn = null;
		try {
			conn = dao.getConnection();
			conn.setAutoCommit(false);
			
			// insert into flight 
			String flightquery = "insert into flight values(?, ? , ? , ? ,? ,? );";
			PreparedStatement prepstmt = conn.prepareStatement(flightquery);
			
			prepstmt.setInt(1, flight.getFlightId());
			prepstmt.setString(2, flight.getFlightName());
			prepstmt.setInt(3, flight.getFuelCapacity());
			prepstmt.setDouble(4, flight.getArrivalTime());
			prepstmt.setString(5, flight.getSource());
			prepstmt.setString(6, flight.getDestination());
			
			int flightresult = prepstmt.executeUpdate();
			System.out.println(flightresult);
			
			// insert into ticket
			String ticketQuery = "insert into ticket values(?,?,?,?,?)";
			
			PreparedStatement prepstmt2 = conn.prepareStatement(ticketQuery);
			prepstmt2.setInt(1, ticket.getTicketId());
			prepstmt2.setString(2, ticket.getSeatNum());
			prepstmt2.setDouble(3, ticket.getPrice());
			prepstmt2.setInt(4, ticket.getPax());
			prepstmt2.setString(5, ticket.getType());
			
			int ticketResult = prepstmt2.executeUpdate();
			System.out.println(ticketResult);
			
			System.out.println("Everything was sucessfully executed");
			conn.commit();
			
			
		} catch (SQLException e) {
			try {
				System.out.println("Rolling back since something went wrong");
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Exception e) {
			try {
				System.out.println("Rolling back since something went wrong");
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		

	}

}
