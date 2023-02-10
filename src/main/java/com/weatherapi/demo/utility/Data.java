package com.weatherapi.demo.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weatherapi.demo.model.Daily;
import com.weatherapi.demo.model.WeatherData;
import com.weatherapi.demo.service.OpenWeatherService;

public class Data {

	
	public WeatherData weatherImperial(OpenWeatherService weatherService, double lat, double lon) {

		WeatherData imperialData = weatherService.getWeatherMetric(lat, lon);
		
		
		imperialData.getMain().setTemp((int) (imperialData.getMain().getTemp() * 1.8) + 32);
		imperialData.getMain().setFeels_like((int) (imperialData.getMain().getFeels_like() * 1.8) + 32);
		imperialData.getMain().setTemp_min((int) (imperialData.getMain().getTemp_min() * 1.8) + 32);
		imperialData.getMain().setTemp_max((int) (imperialData.getMain().getTemp_max() * 1.8) + 32);
		imperialData.getWind().setSpeed((int) ((imperialData.getWind().getSpeed()) / 1.609344));
		
		return imperialData;
		
	}
	
	public Map<Integer, List<Daily>> forecastMetric(OpenWeatherService weatherService) {
		
		Map<Integer, List<Daily>> forecastMetric = new HashMap<>();

		
		for (Daily forecast : weatherService.getForecastMetric().getList()) {
			
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dt = LocalDateTime.parse(forecast.getDt_txt(), formatter);
		
			int dayOfMonth = dt.getDayOfMonth();
			
			forecast.setDt_txt(dt.getDayOfWeek().toString());
			
			
			if (forecastMetric.containsKey(dayOfMonth)) {
				
				forecastMetric.get(dayOfMonth).add(forecast);
				
			} else {
				
				forecastMetric.put(dayOfMonth, new ArrayList<>());
				
			}
			
		}
		
		List<Integer> keysToRemove = new ArrayList<>();

		for (Integer day : forecastMetric.keySet()) {
			
			if (forecastMetric.get(day).isEmpty()) {
				keysToRemove.add(day);
			}
		}

		for (Integer day : keysToRemove) {
			forecastMetric.remove(day);
		}

		
		return forecastMetric;
		
	}
	
	
	public Map<Integer, List<Daily>> forecastImperial(Map<Integer, List<Daily>> forecastMetric) {
		
		Map<Integer, List<Daily>> forecastImperial = new HashMap<>();
		
		forecastImperial.putAll(forecastMetric);
		

		for (Integer forecast : forecastImperial.keySet()) {
			
			
			
			for (Daily day : forecastImperial.get(forecast)) {
				
				int temp = day.getMain().getTemp();
				int minTemp = day.getMain().getTemp();
				int maxTemp = day.getMain().getTemp();
				int feelsLike = day.getMain().getFeels_like();
				int windSpeed = day.getWind().getSpeed();
				
				
				day.getMain().setTemp((int) (temp * 1.8) + 32);
				day.getMain().setTemp_min((int) (minTemp * 1.8) + 32);
				day.getMain().setTemp_max((int) (maxTemp * 1.8) + 32);
				day.getMain().setFeels_like((int) (feelsLike * 1.8) + 32);
				day.getWind().setSpeed((int) (windSpeed / 1.609344));
			}
			

		}
		
		return forecastImperial;
		
	}
	
	public Map<Integer, MinMax> getMinMax(Map<Integer, List<Daily>> forecastMetric) {
		
		Map<Integer, MinMax> minMax = new HashMap<>();
		
		
		for (Integer day : forecastMetric.keySet()) {
			
			if (!minMax.containsKey(day)) {
				minMax.put(day, new MinMax());
			}
			
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			
			for (Daily hour : forecastMetric.get(day)) {
				
				min = Math.min(min, hour.getMain().getTemp_min());
				max = Math.max(max, hour.getMain().getTemp_max());
				
			}
			
			minMax.get(day).setMaxTemp(max);
			minMax.get(day).setMinTemp(min);
			
		}
		
		return minMax;
		
	}
	
}
