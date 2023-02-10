package com.weatherapi.demo.utility;

public class MinMax {

	private int minTemp;
	
	private int maxTemp;

	
	
	public MinMax() {
		
		this.minTemp = 0;
		this.maxTemp = 0;

		
	}


	public int getMinTemp() {
		return minTemp;
	}


	public void setMinTemp(int minTemp) {
		this.minTemp = minTemp;
	}


	public int getMaxTemp() {
		return maxTemp;
	}


	public void setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
	}


	@Override
	public String toString() {
		return "MinMax [minTemp=" + minTemp + ", maxTemp=" + maxTemp + "]";
	}
	

	


	
	
	
	
	
}
