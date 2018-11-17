package com.gojek.parkinglot.model;

public class ParkingInvoice {

	private Car car;
	private double ticketAmount;
	private ParkingLot parkingLot;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public double getTicketAmount() {
		return ticketAmount;
	}
	public void setTicketAmount(double ticketAmount) {
		this.ticketAmount = ticketAmount;
	}
	public ParkingLot getParkingLot() {
		return parkingLot;
	}
	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	
	
}
