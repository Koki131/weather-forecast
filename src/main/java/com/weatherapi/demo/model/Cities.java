package com.weatherapi.demo.model;

import java.util.List;

public class Cities {

	
	private List<City> list;

	public List<City> getList() {
		return list;
	}

	public void setList(List<City> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Cities [list=" + list + "]";
	}
	
	
}
