package com.weatherapi.demo.model;

import java.util.List;

public class AQI {

	private List<AirQuality> list;

	public List<AirQuality> getList() {
		return list;
	}

	public void setList(List<AirQuality> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "AQI [list=" + list + "]";
	}
	
	
	
}
