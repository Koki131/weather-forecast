package com.weatherapi.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
	
	private int temp;
	private int feels_like;
	private int pressure;
	private int humidity;
	private int temp_min;
	private int temp_max;
	
	public Main() {
		
	}

	

	public int getTemp() {
		return temp;
	}



	public void setTemp(int temp) {
		this.temp = temp;
	}



	public int getFeels_like() {
		return feels_like;
	}



	public void setFeels_like(int feels_like) {
		this.feels_like = feels_like;
	}



	public int getPressure() {
		return pressure;
	}



	public void setPressure(int pressure) {
		this.pressure = pressure;
	}



	public int getHumidity() {
		return humidity;
	}



	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}



	public int getTemp_min() {
		return temp_min;
	}



	public void setTemp_min(int temp_min) {
		this.temp_min = temp_min;
	}



	public int getTemp_max() {
		return temp_max;
	}



	public void setTemp_max(int temp_max) {
		this.temp_max = temp_max;
	}



	@Override
	public String toString() {
		return "Main [temp=" + temp + ", feels_like=" + feels_like + ", pressure=" + pressure + ", humidity=" + humidity
				+ ", temp_min=" + temp_min + ", temp_max=" + temp_max + "]";
	}

	
	
	
}
