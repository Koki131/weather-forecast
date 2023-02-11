package com.weatherapi.demo.model;

public class AirQuality {

	
	private AirQualityMain main;

	public AirQualityMain getMain() {
		return main;
	}

	public void setMain(AirQualityMain main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return "AirQuality [main=" + main + "]";
	}
	
	
	
}
