package com.xworkz.happytours.dao;

import java.sql.Connection;

public interface HappyTourUserDao {
	
	Connection getConnnection();
	boolean save() ;

}
