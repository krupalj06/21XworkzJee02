package com.xworkz.happytours.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.happytours.dao.HappyTourUserDao;

public class HappyTourUserDaoImpl  implements HappyTourUserDao{

	@Override
	public boolean save() {
		
		try {
		Connection connection = getConnnection();
		
		String sqlQuery = "insert into happytouruser (firstname, lastname, emailid, username, password) " + 
				"values(? , ? , ? , ?, ? );";
		
		PreparedStatement stmt = connection.prepareStatement(sqlQuery);
		
		
		}catch (Exception e) {
			e.getStackTrace();
		}
		
		return false;
	}

	@Override
	public Connection getConnnection() {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "root123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}

	
}
