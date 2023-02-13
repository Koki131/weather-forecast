package com.weatherapi.demo.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

	
	private String name;
	private List<Weather> weather;
	private Main main;
	private Wind wind;
	private long dt;
	private long timezone;
	private Sys sys;
	private Coord coord;
	
	
	
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

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	
	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}
	

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public long getTimezone() {
		return timezone;
	}

	public void setTimezone(long timezone) {
		this.timezone = timezone;
	}

	
	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	@Override
	public String toString() {
		return "WeatherData [name=" + name + ", weather=" + weather + ", main=" + main + ", wind=" + wind + ", dt=" + dt
				+ ", timezone=" + timezone + ", sys=" + sys + ", coord=" + coord + "]";
	}

	
	

	
	

	
	
	
	
}

