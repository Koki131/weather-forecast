package com.weatherapi.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weatherapi.demo.model.AQI;
import com.weatherapi.demo.model.Cities;
import com.weatherapi.demo.model.City;
import com.weatherapi.demo.model.Forecast;
import com.weatherapi.demo.model.Location;
import com.weatherapi.demo.model.WeatherData;

@Service
public class OpenWeatherServiceImpl implements OpenWeatherService {

	// Enter your OpenWeather API Key
	private final String API_KEY = "44d787fd0b69742e54064148525b2649";
	
	private final String API_URL = "https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid=" + API_KEY + "&units=metric";
	
	private final String CITY_FINDER_URL = "https://api.openweathermap.org/data/2.5/find?q={city}&appid=" + API_KEY + "&units=metric";
	
	private final String FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast?lat={lat}&lon={lon}&appid=" + API_KEY + "&units=metric";
	
	private final String AQI_URL = "http://api.openweathermap.org/data/2.5/air_pollution?lat={lat}&lon={lon}&appid=" + API_KEY;
	
	private final String FORECAST_AQI_URL = "http://api.openweathermap.org/data/2.5/air_pollution/forecast?lat={lat}&lon={lon}&appid=" + API_KEY;


	private double lat;
	private double lon;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@Override
	public WeatherData getWeatherMetric(double lat, double lon) {
	
		
		WeatherData response = restTemplate.getForObject(API_URL, WeatherData.class, lat, lon);
		
		this.lat = lat;
		this.lon = lon;
		
		
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

	@Override
	public AQI getAQI(double lat, double lon) {
		
		AQI airQuality = restTemplate.getForObject(AQI_URL, AQI.class, lat, lon);
		
		return airQuality;
		
	}

}
