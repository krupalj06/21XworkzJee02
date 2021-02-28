package com.xworkz.nykaastore.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.nykaastore.dto.Cosmetics;

public interface CosmeticsDao {
	
	Connection getDBConnection() throws ClassNotFoundException, SQLException;
	
//	CRUD
	boolean save(Cosmetics cosmetics); //create
	
	ArrayList<Cosmetics> readAllRecords();
	
	boolean updateRecordBasedOnBrand(double newPriceValue, String brand);
	
	boolean deleteRecordBasedonCosmeticId(int cosmeticId);
	
	// reading name, brand from table 
	
	//Display total records from the table 
	
	//display record whose price is Highest 

}
