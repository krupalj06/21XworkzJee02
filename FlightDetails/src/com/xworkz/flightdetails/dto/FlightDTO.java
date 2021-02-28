package com.xworkz.flightdetails.dto;

public class FlightDTO {
	
    private int flightId;
    private String flightName;
    private int fuelCapacity;
    private double arrivalTime;
    private String source;
    private String destination;
    
    public FlightDTO() {
	}

	public FlightDTO(int flightId, String flightName, int fuelCapacity, double arrivalTime, String source,
			String destination) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.fuelCapacity = fuelCapacity;
		this.arrivalTime = arrivalTime;
		this.source = source;
		this.destination = destination;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public double getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(double arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "FlightDTO [flightId=" + flightId + ", flightName=" + flightName + ", fuelCapacity=" + fuelCapacity
				+ ", arrivalTime=" + arrivalTime + ", source=" + source + ", destination=" + destination + "]";
	}
	
}
