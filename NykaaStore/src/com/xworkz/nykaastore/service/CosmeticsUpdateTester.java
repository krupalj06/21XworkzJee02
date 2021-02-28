package com.xworkz.nykaastore.service;

import com.xworkz.nykaastore.dao.CosmeticsDao;
import com.xworkz.nykaastore.dao.impl.CosmeticsDaoImpl;

public class CosmeticsUpdateTester {
	public static void main(String[] args) {
		
		CosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
		boolean result = cosmeticsDao.updateRecordBasedOnBrand(450.00, "Mabiline");
		
		System.out.println("Was table updated ? "+ result);
		
	}

}
