package com.weatherapi.demo.service;

import com.weatherapi.demo.model.Cities;
import com.weatherapi.demo.model.Forecast;
import com.weatherapi.demo.model.WeatherData;

public interface OpenWeatherService {

	
	WeatherData getWeatherMetric(String city);
	
	Forecast getForecastMetric();
	
	Cities getCities(String city);
	
}
