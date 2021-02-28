package com.xworkz.nykaastore.service;

import java.util.ArrayList;

import com.xworkz.nykaastore.dao.impl.CosmeticsDaoImpl;
import com.xworkz.nykaastore.dto.Cosmetics;

public class CosmeticsReadTester {
	
	public static void main(String[] args) {
		
		CosmeticsDaoImpl cosmeticsDaoImpl = new CosmeticsDaoImpl();
		
		ArrayList<Cosmetics> cosmeticsList = cosmeticsDaoImpl.readAllRecords();
		
		for (Cosmetics cosmetics : cosmeticsList) {
			System.out.println("CosmeticId is: " + cosmetics.getCosmeticsId());
			System.out.println("Cosmetics name: "+ cosmetics.getName());
			System.out.println("Cosmetics price: "+ cosmetics.getPrice());
			System.out.println("Cosmetics qnt: "+ cosmetics.getQuantity());
			System.out.println("Cosmetics brand: "+ cosmetics.getBrand());
			System.out.println("==========================================");
		}
		
	}

}
