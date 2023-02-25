package com.example.demo.entity;

public class Location {
	private Double x;
	
	private Double y;

	public Location(Double x, Double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public int getDistance(Location location) {
		return (int) Math.sqrt(Math.pow(this.x - location.getX(), 2) 
				+ Math.pow(this.y - location.getY(), 2));
	}
	
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}
	
}
