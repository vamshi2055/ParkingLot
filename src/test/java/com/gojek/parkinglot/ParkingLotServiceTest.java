package com.gojek.parkinglot;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.gojek.parkinglot.model.Car;
import com.gojek.parkinglot.model.ParkingInvoice;
import com.gojek.parkinglot.service.ParkingLotServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParkingLotServiceTest {

	ParkingLotServiceImpl parkingLotService = new ParkingLotServiceImpl();

	@Test
	public void testParkingLot() throws Exception {

		/* Testing Create Parking Lot */
		parkingLotService.createParkingLot(6);
		assertEquals(6, parkingLotService.getAvailableSlots().size());

		/* Testing Parking Facility */
		Car car = new Car();
		/* Parking First Car */

		car.setCarColor("White");
		car.setRegistrationNumber("KA-01-HH-1234");
		ParkingInvoice invoice = parkingLotService.parkCar(car);
		assertEquals(1, invoice.getParkingLot().getSlotNumber().intValue());
		parkingLotService.getParkingStatus();

		/* Parking Second Car */
		Car car2 = new Car();
		car2.setCarColor("White");
		car2.setRegistrationNumber("KA-01-HH-9999");
		invoice = parkingLotService.parkCar(car2);
		System.out.println(invoice.getCar().getRegistrationNumber());
		assertEquals(2, invoice.getParkingLot().getSlotNumber().intValue());
		parkingLotService.getParkingStatus();

		/* Parking Third Car */
		Car car3 = new Car();
		car3.setCarColor("Black");
		car3.setRegistrationNumber("KA-01-BB-0001");
		invoice = parkingLotService.parkCar(car3);
		System.out.println(invoice.getCar().getRegistrationNumber());
		assertEquals(3, invoice.getParkingLot().getSlotNumber().intValue());

		/* Parking Fourth Car */
		Car car4 = new Car();
		car4.setCarColor("Red");
		car4.setRegistrationNumber("KA-01-HH-7777");
		invoice = parkingLotService.parkCar(car4);
		System.out.println(invoice.getCar().getRegistrationNumber());
		assertEquals(4, invoice.getParkingLot().getSlotNumber().intValue());

		/* Parking Fifth Car */
		Car car5 = new Car();
		car5.setCarColor("Blue");
		car5.setRegistrationNumber("KA-01-HH-2701");
		invoice = parkingLotService.parkCar(car5);
		System.out.println(invoice.getCar().getRegistrationNumber());
		assertEquals(5, invoice.getParkingLot().getSlotNumber().intValue());

		/* Parking Sixth Car */
		Car car6 = new Car();
		car6.setCarColor("Black");
		car6.setRegistrationNumber("KA-01-HH-3141");
		invoice = parkingLotService.parkCar(car6);
		System.out.println(invoice.getCar().getRegistrationNumber());
		assertEquals(6, invoice.getParkingLot().getSlotNumber().intValue());
		assertEquals(0, parkingLotService.getAvailableSlots().size());

		/* Testing Exit Parking */
		parkingLotService.exitParkingLot(3);
		assertEquals(true, parkingLotService.getAvailableSlots().contains(3));
		parkingLotService.getParkingStatus();

		/* Testing Car search based on Registration Number */
		String slotNumberSearch = parkingLotService.getParkedSlotNumberBasedOnRegistrationNumber("KA-01-HH-9999");
		assertEquals("Allocated slot number:2", slotNumberSearch);

		/* Testing Car search based on Color */

		String colorSearch = parkingLotService.getParkedCarsRegNumberBasedOnColor("White");
		assertEquals("KA-01-HH-1234,KA-01-HH-9999", colorSearch);

		/* Testing Slot number based on Color */

		String slotSearch = parkingLotService.getParkedSlotNumberBasedOnColor("White");
		assertEquals("1,2", slotSearch);

	}

}
