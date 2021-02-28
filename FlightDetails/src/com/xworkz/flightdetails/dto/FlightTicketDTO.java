package com.xworkz.flightdetails.dto;

public class FlightTicketDTO {
	private int ticketId;
	private String seatNum;
	private double price;
	private int pax;
	private String type;
	
	public FlightTicketDTO() {
	}

	public FlightTicketDTO(int ticketId, String seatNum, double price, int pax, String type) {
		super();
		this.ticketId = ticketId;
		this.seatNum = seatNum;
		this.price = price;
		this.pax = pax;
		this.type = type;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPax() {
		return pax;
	}

	public void setPax(int pax) {
		this.pax = pax;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "FlightTicketDTO [ticketId=" + ticketId + ", seatNum=" + seatNum + ", price=" + price + ", pax=" + pax
				+ ", type=" + type + "]";
	}

}
