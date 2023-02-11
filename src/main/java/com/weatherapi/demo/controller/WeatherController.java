package com.weatherapi.demo.controller;



import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weatherapi.demo.model.City;
import com.weatherapi.demo.service.OpenWeatherService;
import com.weatherapi.demo.service.OpenWeatherServiceImpl;
import com.weatherapi.demo.utility.Data;
import com.weatherapi.demo.utility.MinMax;

@Controller
public class WeatherController {

	@Autowired
	private OpenWeatherService weatherService;
	
	private Data data;
	
	@PostConstruct
	public void init() {
		this.data = new Data();
	}
	
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
	public String getWeather(@RequestParam("lat") double lat, @RequestParam("lon") double lon, Model model) {
		
		Date date = new Date(weatherService.getWeatherMetric(lat, lon).getDt() * 1000);
		
		Map<Integer, MinMax> minMax = data.getMinMax(data.forecastMetric(weatherService));
		
		
		model.addAttribute("weatherData",  weatherService.getWeatherMetric(lat, lon));
		model.addAttribute("weatherImperial", data.weatherImperial(weatherService, lat, lon));
		model.addAttribute("forecast", data.forecastMetric(weatherService));
		model.addAttribute("minMax", minMax);
		model.addAttribute("airQuality", weatherService.getAQI(lat, lon));
		model.addAttribute("date", date);
		
				
		return "weather";
	}
	

	
}
