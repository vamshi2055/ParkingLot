package com.gojek.parkinglot;

import java.io.IOException;
import java.util.Scanner;

import com.gojek.parkinglot.command.execution.ParkingLotCommandExecution;
import com.gojek.parkinglot.model.Car;
import com.gojek.parkinglot.model.ParkingInvoice;
import com.gojek.parkinglot.service.ParkingLotService;
import com.gojek.parkinglot.service.ParkingLotServiceImpl;
import com.gojek.parkinglot.utilities.ParkingLotException;


public class GoJekParkingApp 


{
    public static void main(String[] args) throws IOException, ParkingLotException
    {
      
    	
    		Scanner scanner = new Scanner(System.in);
    		
            System.out.println("Welcome to GoJek Parking lot solution");
            System.out.println("Please enter an input");
           
            ParkingLotCommandExecution parkingLotCommandExecution=new ParkingLotCommandExecution();
            if (args != null && args.length > 0) {
    			String fileName = args[0];
    			if (fileName != null && !fileName.isEmpty()) {
    				parkingLotCommandExecution.executeCommandsViaFile(fileName);

    			}
    		} else {
    			parkingLotCommandExecution.executeCommandLineInputs();
    		}
            
      
    }
}
