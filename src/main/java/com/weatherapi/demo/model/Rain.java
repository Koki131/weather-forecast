package com.weatherapi.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {

	@JsonProperty("3h")
	private double threeHour;

	public double getThreeHour() {
		return threeHour;
	}

	public void setThreeHour(double threeHour) {
		this.threeHour = threeHour;
	}

	@Override
	public String toString() {
		return "Rain [threeHour=" + threeHour + "]";
	}
	
	
	
}
