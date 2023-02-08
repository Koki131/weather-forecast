package com.weatherapi.demo.model;

import java.util.List;

public class Daily {

	private Main main;
	private List<Weather> weather;
	private String dt_txt;

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

	

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "Daily [main=" + main + ", weather=" + weather + ", dt_txt=" + dt_txt + "]";
	}

	
	
	
	
	
}
