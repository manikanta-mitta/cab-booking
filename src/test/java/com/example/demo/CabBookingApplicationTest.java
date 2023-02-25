package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.controllers.DriverController;
import com.example.demo.controllers.UserController;
import com.example.demo.entity.Driver;
import com.example.demo.entity.Location;
import com.example.demo.entity.User;
import com.example.demo.service.DriverService;
import com.example.demo.service.RideService;
import com.example.demo.service.UserService;

public class CabBookingApplicationTest {
	
	UserController userController;
	
	DriverController driverController;
	
	@BeforeEach
	public void createAllServices() {
		UserService userService = new UserService();
		
		
		DriverService driverService = new DriverService();
		
		
		RideService rideSerivce = new RideService(driverService);
		userController = new UserController(userService, rideSerivce);
		
		driverController = new DriverController(driverService, rideSerivce);
	}
	
	@Test
	public void tests() {
		
		//Adding Users
		User testUser = new User("Nandhini", 21, 'F');
		System.out.println(userController.addUser(testUser));
		
		testUser = new User("Ram", 42, 'M');
		System.out.println(userController.addUser(testUser));
		
		testUser = new User("Shyam", 24, 'M');
		System.out.println(userController.addUser(testUser));
		
		testUser = new User("Nandhini", 21, 'F');
		System.out.println(userController.addUser(testUser));
		
		//On boarding Drivers with their, vehicle and location details
		Driver driver = new Driver(
				"Driver1", 'M', 22, "Swift", "KA-01-12345", new Location(10.0, 1.0));
		
		System.out.println(driverController.addDriver(driver));
		
		driver = new Driver(
				"Driver2", 'M', 29, "Swift", "KA-01-12345", new Location(11.0, 10.0));
	
		System.out.println(driverController.addDriver(driver));
		
		driver = new Driver(
				"Driver3", 'M', 24, "Swift", "KA-01-12345", new Location(5.0, 3.0));
	
		System.out.println(driverController.addDriver(driver));
		
		driver = new Driver(
				"Driver3", 'M', 24, "Swift", "KA-01-12345", new Location(5.0, 3.0));
	
		System.out.println(driverController.addDriver(driver));
		
		//Finding List of available Riders
		List<String> availableRides = userController.findRide("Nandhini" ,new Location(0.0,0.0), new Location(20.0,1.0));
		System.out.println(availableRides);
		
		
		availableRides = userController.findRide("Shyam" ,new Location(10.0,0.0), new Location(15.0,3.0));
		System.out.println(availableRides);
		
//		user chooses ride
		String message = userController.chooseRide("Shyam", "Driver1", new Location(10.0,0.0), new Location(15.0,3.0));
		
		System.out.println(message);
		
		availableRides = userController.findRide("Ram" ,new Location(10.0,0.0), new Location(15.0,3.0));
		System.out.println(availableRides);
		
//		Driver 1 ends the ride
		message = driverController.endCurrentRide("Driver1", new Location(2.0, 5.0));
		System.out.println(message);
		
		availableRides = userController.findRide("Ram" ,new Location(2.0,0.0), new Location(10.0,3.0));
		System.out.println(availableRides);
		
	}
	
	
}
