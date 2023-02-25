package com.example.demo.controllers;

import org.springframework.lang.NonNull;

import com.example.demo.entity.Driver;
import com.example.demo.entity.Location;
import com.example.demo.exception.DriverAlreadyExistsException;
import com.example.demo.service.DriverService;
import com.example.demo.service.RideService;

public class DriverController {
	
	DriverService driverService;
	RideService rideService;
	
	public DriverController(DriverService driverService, RideService rideService) {
		super();
		this.driverService = driverService;
		this.rideService = rideService;
	}

	public String addDriver(@NonNull Driver driver) {

		String message = "";

		try {
			this.driverService.addDriver(driver);
			message = driver.toString();
		} catch (DriverAlreadyExistsException e) {
			message = e.getMessage();
		}

		return message;
	}
	
	public String endCurrentRide(String driverName, Location location) {
		return rideService.endRide(driverName, location);
	}
	
	public String updateLocation(String driverName, Location location) {
		return driverService.updateLocation(driverName, location);
	}
}
