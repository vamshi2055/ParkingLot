package com.gojek.parkinglot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gojek.parkinglot.model.Car;
import com.gojek.parkinglot.model.ParkingInvoice;
import com.gojek.parkinglot.model.ParkingLot;
import com.gojek.parkinglot.utilities.ParkingLotException;

public class ParkingLotServiceImpl implements ParkingLotService {
	private int totalParkingSlots;

	private List<Integer> availableSlots;

	private Map<Integer, ParkingInvoice> parkingInvoices;



	public ParkingInvoice parkCar(Car car) throws ParkingLotException {
		if (availableSlots.size() == 0) {
			System.out.println("No parking slots are available");
			throw new ParkingLotException("noParkingSlotsAvailable","No parking slots are available");
		} else {
			ParkingInvoice parkingInvoice = new ParkingInvoice();
			ParkingLot parkingLot = new ParkingLot();
			parkingInvoice.setCar(car);
			parkingLot.setSlotNumber(availableSlots.get(0));
		    parkingInvoice.setParkingLot(parkingLot);
			parkingInvoices.put(availableSlots.get(0), parkingInvoice);
			availableSlots.remove(0);
			System.out.println("Alloted the slot"+parkingInvoice.getParkingLot().getSlotNumber());
			return parkingInvoice;
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public void exitParkingLot(int slotNumber) throws ParkingLotException {

		ParkingInvoice parkingInvoice = parkingInvoices.get(slotNumber);
		if (parkingInvoice != null) {
			System.out.println("In hte slot remove");
			parkingInvoices.remove(parkingInvoice.getCar().getRegistrationNumber());
			availableSlots.add(parkingInvoice.getParkingLot().getSlotNumber());
			Collections.sort(availableSlots);
			System.out.println("availableSlots"+availableSlots.size());
			System.out.println("Slot number "+slotNumber+" is free");
			
		}else
			throw new ParkingLotException("noVehicleParked","No vehicle is parked in the provided parking slot");
			

	}

	
	
	public void getParkedSlotNumberBasedOnColor(String color) {
		StringBuilder builder = new StringBuilder();
		
		for (Map.Entry<Integer, ParkingInvoice> entry : parkingInvoices.entrySet()) {
			if (color.equals(entry.getValue().getCar().getCarColor())) {
				builder.append(entry.getValue().getParkingLot().getSlotNumber()).append(",");
			}
		}
		if(builder.toString().isEmpty()) {
			System.out.println("No Cars present in GoJek Parking Lot with Color "+color);
		}
		System.out.println(builder.substring(1, builder.length()-1));

	}
	
	public void getParkedSlotNumberBasedOnRegistrationNumber(String registrationNumber) {
		
		for (Map.Entry<Integer, ParkingInvoice> entry : parkingInvoices.entrySet()) {
			if (registrationNumber.equals(entry.getValue().getCar().getRegistrationNumber())) {
				System.out.println("Allocated slot number:"+entry.getValue().getParkingLot().getSlotNumber());
			}
		}
		

	}
	
	public void getParkedCarsRegNumberBasedOnColor(String color) {

		StringBuilder builder = new StringBuilder();


		for (Map.Entry<Integer, ParkingInvoice> entry : parkingInvoices.entrySet()) {
			if (color.equals(entry.getValue().getCar().getCarColor())) {
				
				builder.append(entry.getValue().getCar().getRegistrationNumber()).append(",");
			}
		}
		if(builder.toString().isEmpty()) {
			System.out.println("No Cars present in GoJek Parking Lot with Color "+color);
		}
		System.out.println(builder.substring(1, builder.length()-1));

	}
	
	public void getParkingStatus() {

		System.out.println("Slot No.     Registration No   Colour");
		for (Map.Entry<Integer, ParkingInvoice> entry : parkingInvoices.entrySet()) {
				System.out.println(entry.getValue().getParkingLot().getSlotNumber() + "            "
						+ entry.getValue().getCar().getRegistrationNumber() + "     "
						+ entry.getValue().getCar().getCarColor());
			
		}

	}

	public void createParkingLot(int totalSlots) {

		availableSlots=new ArrayList<Integer>();
		this.setTotalParkingSlots(totalSlots);

		for (int i = 1; i <= totalSlots; i++) {
			availableSlots.add(i);
		}
		this.parkingInvoices = new HashMap<Integer, ParkingInvoice>();
		Collections.sort(availableSlots);
		System.out.println("Created a parking lot with "+totalSlots+" slots");
	}

	public int getTotalParkingSlots() {
		return totalParkingSlots;
	}

	public void setTotalParkingSlots(int totalParkingSlots) {
		this.totalParkingSlots = totalParkingSlots;
	}

	public List<Integer> getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(List<Integer> availableSlots) {
		this.availableSlots = availableSlots;
	}

	public Map<Integer, ParkingInvoice> getParkingInvoices() {
		return parkingInvoices;
	}

	public void setParkingInvoices(Map<Integer, ParkingInvoice> parkingInvoices) {
		this.parkingInvoices = parkingInvoices;
	}
	
	

}
