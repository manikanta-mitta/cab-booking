package com.example.demo.entity;

public class Driver {
	private String name;
	
	private Character gender;
	
	private Integer age;
	
	private String carModel;
	
	private String registrationNo;
	
	private Location location;
	
	private Boolean availability;
	
	private Ride currentRide;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	
	public Ride getCurrentRide() {
		return currentRide;
	}

	public void setCurrentRide(Ride currentRide) {
		this.currentRide = currentRide;
	}

	public Driver(String name, Character gender, Integer age, String carModel, String registrationNo,
			Location location) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.carModel = carModel;
		this.registrationNo = registrationNo;
		this.location = location;
		
		this.availability = true;
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", gender=" + gender + ", age=" + age + ", carModel=" + carModel
				+ ", registrationNo=" + registrationNo + ", location=" + location + ", availability=" + availability
				+ "]";
	}
	
}
