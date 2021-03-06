package com.gojek.parkinglot.service;

import com.gojek.parkinglot.model.Car;
import com.gojek.parkinglot.model.ParkingInvoice;
import com.gojek.parkinglot.utilities.ParkingLotException;

public interface ParkingLotService {

	public void createParkingLot(int totalSlots);

	public ParkingInvoice parkCar(Car car) throws ParkingLotException;

	public void getParkingStatus();

	public void exitParkingLot(int slotNumber) throws ParkingLotException;

	public String getParkedCarsRegNumberBasedOnColor(String color);
   
	public String getParkedSlotNumberBasedOnColor(String color);

	public String getParkedSlotNumberBasedOnRegistrationNumber(String registrationNumber);

}
