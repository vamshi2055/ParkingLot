package com.gojek.parkinglot;

import java.io.IOException;
import java.util.Scanner;

import com.gojek.parkinglot.command.execution.ParkingLotCommandExecution;
import com.gojek.parkinglot.model.Car;
import com.gojek.parkinglot.model.ParkingInvoice;
import com.gojek.parkinglot.service.ParkingLotService;
import com.gojek.parkinglot.service.ParkingLotServiceImpl;
import com.gojek.parkinglot.utilities.ParkingLotException;


public class App 


{
    public static void main(String[] args) throws IOException, ParkingLotException
    {
      
    	
    		Scanner scanner = new Scanner(System.in);
    		
            System.out.println("Welcome to GoJek Parking lot solution");
            System.out.println("Please enter an input");
            // Interactive command-line input/output
            // Run an infinite loop
          
            ParkingLotCommandExecution parkingLotCommandExecution=new ParkingLotCommandExecution();
            if (args != null && args.length > 0) {
    			String fileName = args[0];
    			if (fileName != null && !fileName.isEmpty()) {
    				parkingLotCommandExecution.executeCommandsViaFile(fileName);

    			}
    		} else {// execution via commands
    			parkingLotCommandExecution.executeCommandLineInputs();
    		}
            
      /*  ParkingLotService service = new ParkingLotServiceImpl();
        service.createParkingLot(10);
        Car car=new Car();
        car.setCarColor("White");
        car.setRegistrationNumber("KA-01-HH-1234");
        ParkingInvoice invoice=service.parkCar(car);
        System.out.println(invoice.getParkingLot().getSlotNumber());
        service.exitParkingLot(invoice.getParkingLot().getSlotNumber());
        */
    }
}
