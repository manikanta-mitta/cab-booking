package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.Location;
import com.example.demo.entity.Ride;
import com.example.demo.enums.RideStatusConstants;

public class RideService {
	
	DriverService driverService;
	
	Map<String, List<Ride>> rides = new HashMap<>();

	public RideService(DriverService driverService) {
		this.driverService = driverService;
	}

	public String createRide(String userName, String driverName, Location fromLocation, Location toLocation) {
		
		Ride ride = new Ride(userName, driverName, fromLocation, toLocation);
		
		if (!rides.containsKey(ride.getNameOfUser())) {
			rides.put(userName, new ArrayList<Ride>());
		}
		rides.get(userName).add(ride);
		
		driverService.setAvailability(driverName, false);
		driverService.setCurrentRide(driverName, ride);
		
		return "Ride Successfully Created";
	}
	
	public String endRide(String driverName, Location location) {
		Ride ride = driverService.getDriver(driverName).getCurrentRide();
		driverService.setCurrentRide(driverName, null);
		driverService.updateLocation(driverName, location);
		ride.setToLocation(location);
		ride.setRideStatus(RideStatusConstants.ENDED);
		return "Ride Successfully Ended";
	}

	public List<String> getAllAvailableRides(Location fromLocation) {
		return driverService.getAllDrivers().stream().filter(e -> e.getAvailability()
				&& e.getLocation().getDistance(fromLocation) < 5).map(e -> e.getName() + "[Available]").toList();
	}

}
