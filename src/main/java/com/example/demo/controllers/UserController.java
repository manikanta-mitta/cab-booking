package com.example.demo.controllers;

import java.util.List;

import org.springframework.lang.NonNull;

import com.example.demo.entity.Location;
import com.example.demo.entity.User;
import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.service.RideService;
import com.example.demo.service.UserService;

public class UserController {
	
	private UserService userService;
	
	private RideService rideService;
	
	public UserController(UserService userService, RideService rideService) {
		super();
		this.userService = userService;
		this.rideService = rideService;
	}
	
	public String addUser(@NonNull User user) {
		
		String message = "";
		
		try {
			this.userService.addUser(user);
			message = user.toString();
		} catch (UserAlreadyExistsException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	public List<String> findRide(String name, Location fromLocation, Location toLocation) {
		return rideService.getAllAvailableRides(fromLocation);
	}
	
	public String chooseRide(String userName, String driverName, Location fromLocation, Location toLocation) {
		return rideService.createRide(userName, driverName, fromLocation, toLocation);
	}
	
}
