package com.java.esop.dto;

public class Vestingdto {
	
	
	private String year;
	
	private Double vestingFactor;
	
	private Double fareMarketValue;
	
	private String monetizationDate;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Double getVestingFactor() {
		return vestingFactor;
	}

	public void setVestingFactor(Double vestingFactor) {
		this.vestingFactor = vestingFactor;
	}

	public Double getFareMarketValue() {
		return fareMarketValue;
	}

	public void setFareMarketValue(Double fareMarketValue) {
		this.fareMarketValue = fareMarketValue;
	}

	
	public String getMonetizationDate() {
		return monetizationDate;
	}

	public void setMonetizationDate(String monetizationDate) {
		this.monetizationDate = monetizationDate;
	}

	@Override
	public String toString() {
		return "Vestingdto [year=" + year + ", vestingFactor=" + vestingFactor + ", fareMarketValue=" + fareMarketValue
				+ ", monetizationDate=" + monetizationDate + "]";
	}

	
	
	

}
