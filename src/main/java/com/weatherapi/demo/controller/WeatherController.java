package com.weatherapi.demo.controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weatherapi.demo.model.City;
import com.weatherapi.demo.model.Daily;
import com.weatherapi.demo.model.WeatherData;
import com.weatherapi.demo.service.OpenWeatherService;

@Controller
public class WeatherController {

	@Autowired
	private OpenWeatherService weatherService;
	
	
	@GetMapping("/") 
	public String getHome() {	
		
		
		return "index";
	}
	
	@GetMapping("/listCities")
	public String getCities(@RequestParam("city") String city, Model model) {
		
		List<City> cities = weatherService.getCities(city).getList();
		
		
		model.addAttribute("cities", cities);
		model.addAttribute("city", city);
		
		return "cities-list";
		
	}
	
	@GetMapping("/getWeather")
	public String getWeather(@RequestParam("city") String city, Model model) {
		
		
		Date date = new Date(weatherService.getWeatherMetric(city).getDt() * 1000);
			
			
		
		model.addAttribute("weatherData",  weatherService.getWeatherMetric(city));
		model.addAttribute("weatherImperial", weatherImperial(weatherService, city));
		model.addAttribute("forecast", forecastMetric(weatherService));
		model.addAttribute("date", date);
		
				
		return "weather";
	}
	
	public static WeatherData weatherImperial(OpenWeatherService weatherService, String city) {
		
		
		WeatherData imperialData = weatherService.getWeatherMetric(city);
		
		
		imperialData.getMain().setTemp((int) (imperialData.getMain().getTemp() * 1.8) + 32);
		imperialData.getMain().setFeels_like((int) (imperialData.getMain().getFeels_like() * 1.8) + 32);
		imperialData.getMain().setTemp_min((int) (imperialData.getMain().getTemp_min() * 1.8) + 32);
		imperialData.getMain().setTemp_max((int) (imperialData.getMain().getTemp_max() * 1.8) + 32);
		imperialData.getWind().setSpeed((int) ((imperialData.getWind().getSpeed()) / 1.609344));
		
		return imperialData;
		
	}
	
	public static Map<Integer, List<Daily>> forecastMetric(OpenWeatherService weatherService) {
		
		
		Map<Integer, List<Daily>> forecastMetric = new HashMap<>();
		
		
		for (Daily forecast : weatherService.getForecastMetric().getList()) {
			
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dt = LocalDateTime.parse(forecast.getDt_txt(), formatter);
		
			int dayOfMonth = dt.getDayOfMonth();
			
			if (forecastMetric.containsKey(dayOfMonth)) {
				
				forecastMetric.get(dayOfMonth).add(forecast);
				
			} else {
				
				forecastMetric.put(dayOfMonth, new ArrayList<>());
				
			}
			
		}
		
		return forecastMetric;
		
	}
}
