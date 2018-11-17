package com.gojek.parkinglot.utilities;

public class ParkingLotException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ParkingLotException(String code,String message){
		this.message = message;
		this.code =code;
	}
	
	private String message;
	private String code;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
