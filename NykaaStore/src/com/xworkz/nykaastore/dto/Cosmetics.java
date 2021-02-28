package com.xworkz.nykaastore.dto;

public class Cosmetics {
	
	private int cosmeticsId;
	private String name;
	private double price;
	private int quantity;
	private String brand;
	
	public Cosmetics() {
		
	}
	public Cosmetics(int cosmeticsId, String name, double price, int quantity, String brand) {
		super();
		this.cosmeticsId = cosmeticsId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
	}
	public int getCosmeticsId() {
		return cosmeticsId;
	}
	public void setCosmeticsId(int cosmeticsId) {
		this.cosmeticsId = cosmeticsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		return "Cosmetics [cosmeticsId=" + cosmeticsId + ", name=" + name + ", price=" + price + ", quantity="
				+ quantity + ", brand=" + brand + "]";
	}
}
