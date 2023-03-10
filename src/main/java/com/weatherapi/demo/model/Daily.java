package com.weatherapi.demo.model;

import java.util.List;

public class Daily {

	private Main main;
	private List<Weather> weather;
	private String dt_txt;
	private Wind wind;
	private Rain rain;
	private double pop;

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

	

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	
	
	public Rain getRain() {
		return rain;
	}

	public void setRain(Rain rain) {
		this.rain = rain;
	}

	
	public double getPop() {
		return pop;
	}

	public void setPop(double pop) {
		this.pop = pop;
	}

	@Override
	public String toString() {
		return "Daily [main=" + main + ", weather=" + weather + ", dt_txt=" + dt_txt + ", wind=" + wind + ", rain="
				+ rain + ", pop=" + pop + "]";
	}

	

	
	
	
	
	
}
