package com.weatherapi.demo.model;

import java.util.List;

public class Forecast {

	
	private List<Daily> list;

	public List<Daily> getList() {
		return list;
	}

	public void setList(List<Daily> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Forecast [list=" + list + "]";
	}
	
	
	
}
