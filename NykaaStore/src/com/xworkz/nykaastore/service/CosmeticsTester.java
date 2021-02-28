package com.xworkz.nykaastore.service;

import java.util.ArrayList;

import com.xworkz.nykaastore.dao.CosmeticsDao;
import com.xworkz.nykaastore.dao.impl.CosmeticsDaoImpl;
import com.xworkz.nykaastore.dto.Cosmetics;

public class CosmeticsTester {

	public static void main(String[] args) {
		
		CosmeticsDao cosmeticsDaoImpl = new CosmeticsDaoImpl();
		ArrayList<Cosmetics> cosmeticsList = new ArrayList<Cosmetics>();
		// Add 5 records
		// Insert into DB
		Cosmetics cosmetics = new Cosmetics(5, "Maskara", 500.00, 2, "Sugar"); 
		System.out.println("Saving the record to DB : "+ cosmetics);
		
		boolean result = cosmeticsDaoImpl.save(cosmetics);
		
		if(result) {
			System.out.println("Record sucessfully inserted ");
		} else {
			System.out.println("There was some problem whhile record inserting");
		}

	}

}
