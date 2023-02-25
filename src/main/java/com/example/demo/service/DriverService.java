package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.Driver;
import com.example.demo.entity.Location;
import com.example.demo.entity.Ride;
import com.example.demo.exception.DriverAlreadyExistsException;

public class DriverService {
	
private Map<String, Driver> drivers = new HashMap<>();
	
	public void addDriver(Driver driver) throws DriverAlreadyExistsException {
		
		if (drivers.containsKey(driver.getName())) {
			throw new DriverAlreadyExistsException("Driver already Exists.");
		}
		drivers.put(driver.getName(), driver);
	}

	public boolean doesDriverExist(String driverName) {
		return drivers.containsKey(driverName);
	}
	
	public Driver getDriver(String driverName) {
		return drivers.get(driverName);
	}


	public void setAvailability(String driverName, boolean b) {
		getDriver(driverName).setAvailability(b);
	}


	public void setCurrentRide(String driverName, Ride ride) {
		getDriver(driverName).setCurrentRide(ride);
	}
	
	public String updateLocation(String driverName, Location location) {
		getDriver(driverName).setLocation(location);
		return "Location updated successfully";
	}
	
	public List<Driver> getAllDrivers() {
		return drivers.values().stream().toList();
	}
}
