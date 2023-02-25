package com.example.demo.entity;

import com.example.demo.enums.RideStatusConstants;

public class Ride {

	

	public Ride(String nameOfUser, String nameOfDriver, Location fromLocation, Location toLocation) {
		super();
		this.nameOfUser = nameOfUser;
		this.nameOfDriver = nameOfDriver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.rideStatus = RideStatusConstants.INPROCESS;
	}

	private String nameOfUser;
	
	private String nameOfDriver;
	
	private Location fromLocation;
	
	private Location toLocation;
	
	private String rideStatus;

	public String getNameOfUser() {
		return nameOfUser;
	}

	public void setNameOfUser(String nameOfUser) {
		this.nameOfUser = nameOfUser;
	}

	public String getNameOfDriver() {
		return nameOfDriver;
	}

	public void setNameOfDriver(String nameOfDriver) {
		this.nameOfDriver = nameOfDriver;
	}

	public Location getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(Location fromLocation) {
		this.fromLocation = fromLocation;
	}

	public Location getToLocation() {
		return toLocation;
	}

	public void setToLocation(Location toLocation) {
		this.toLocation = toLocation;
	}

	public String getRideStatus() {
		return rideStatus;
	}

	public void setRideStatus(String rideStatus) {
		this.rideStatus = rideStatus;
	}

	@Override
	public String toString() {
		return "Ride [nameOfUser=" + nameOfUser + ", nameOfDriver=" + nameOfDriver + ", fromLocation=" + fromLocation
				+ ", toLocation=" + toLocation + ", rideStatus=" + rideStatus + "]";
	}

}
