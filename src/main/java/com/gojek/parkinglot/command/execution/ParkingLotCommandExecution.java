package com.gojek.parkinglot.command.execution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import com.gojek.parkinglot.model.Car;
import com.gojek.parkinglot.model.ParkingInvoice;
import com.gojek.parkinglot.service.ParkingLotService;
import com.gojek.parkinglot.service.ParkingLotServiceImpl;
import com.gojek.parkinglot.utilities.ParkingLotException;

public class ParkingLotCommandExecution {

	ParkingLotService parkingLotService = new ParkingLotServiceImpl();

	public void executeCommandsViaFile(String fileName) throws IOException, ParkingLotException {
		System.out.println("Reading from file an input");

		List<String> commands = Files.readAllLines(Paths.get(fileName));
		for (String command : commands) {
			executeCommand(command);
		}
	}

	public void executeCommand(String command) throws ParkingLotException {

		if (command == null || command.isEmpty()) {
			throw new ParkingLotException("noCommandProvided", "No Command is inputted.");
		}
		String split[] = command.split(" ");
		if (command.contains("create_parking_lot")) {
			parkingLotService.createParkingLot(Integer.parseInt(split[1]));

		} else if (command.startsWith("park")) {
			Car car = new Car();
			car.setCarColor(split[2]);
			car.setRegistrationNumber(split[1]);
			try {
				ParkingInvoice invoice = parkingLotService.parkCar(car);
			} catch (ParkingLotException e) {
				System.out.println("Sorry the Go Jek parking lot is full.");
			}

		} else if (command.startsWith("leave")) {
			try {
				parkingLotService.exitParkingLot(Integer.parseInt(split[1]));
			} catch (ParkingLotException e) {
				System.out.println(e.getMessage());
			}

		} else if (command.startsWith("status")) {
			parkingLotService.getParkingStatus();

		} else if (command.startsWith("registration_numbers_for_cars_with_colour")) {
			parkingLotService.getParkedCarsRegNumberBasedOnColor(split[1]);

		} else if (command.startsWith("slot_numbers_for_cars_with_colour")) {
			parkingLotService.getParkedSlotNumberBasedOnColor(split[1]);

		} else if (command.startsWith("slot_number_for_registration_number")) {
			parkingLotService.getParkedSlotNumberBasedOnRegistrationNumber(split[1]);
		}else {
			System.out.println("Invalid Command");
		}

	}

	public void executeCommandLineInputs() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String command = sc.nextLine();
			try {
				executeCommand(command);
			} catch (Exception e) {
				sc.close();
			}

		}

	}
}
