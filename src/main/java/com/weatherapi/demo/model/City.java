package com.weatherapi.demo.model;

import java.util.List;

public class City {
	
	private String name;
	private Main main;
	private Sys sys;
	private List<Weather> weather;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", main=" + main + ", sys=" + sys + ", weather=" + weather + "]";
	}

	

	

	
	
}
