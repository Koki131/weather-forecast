package com.weatherapi.demo.model;

public class Location {

	
	private String name;
	private double lat;
	private double lon;
	private String country;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Location [name=" + name + ", lat=" + lat + ", lon=" + lon + ", country=" + country + "]";
	}
	
	
}
