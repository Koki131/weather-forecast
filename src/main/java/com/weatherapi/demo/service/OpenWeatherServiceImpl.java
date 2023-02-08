package com.weatherapi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weatherapi.demo.model.Cities;
import com.weatherapi.demo.model.City;
import com.weatherapi.demo.model.Forecast;
import com.weatherapi.demo.model.Location;
import com.weatherapi.demo.model.WeatherData;

@Service
public class OpenWeatherServiceImpl implements OpenWeatherService {
	
	private final String API_KEY = "YOUR API KEY";
	
	private final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid=" + API_KEY + "&units=metric";
	private final String CITY_FINDER_URL = "https://api.openweathermap.org/data/2.5/find?q={city}&appid=" + API_KEY + "&units=metric";
			
	
	private final String GEO_URL = "http://api.openweathermap.org/geo/1.0/direct?q={city}&appid=" + API_KEY;
	
	private final String FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast?lat={lat}&lon={lon}&appid=" + API_KEY + "&units=metric";

	
	
	private double lat;
	private double lon;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public WeatherData getWeatherMetric(String city) {
		
		WeatherData response = restTemplate.getForObject(API_URL, WeatherData.class, city);
	
		
		Location[] location = restTemplate.getForObject(GEO_URL, Location[].class, city);
		
		for (Location loc : location) {
			lat = loc.getLat();
			lon = loc.getLon();
		}
		
		
		
		return response;
	}

	@Override
	public Forecast getForecastMetric() {
		
		Forecast response = restTemplate.getForObject(FORECAST_URL, Forecast.class, lat, lon);

		return response;
		
	}
	
	@Override
	public Cities getCities(String city) {
		
		Cities cities = restTemplate.getForObject(CITY_FINDER_URL, Cities.class, city);
		
		
		return cities;
		
	}



}
