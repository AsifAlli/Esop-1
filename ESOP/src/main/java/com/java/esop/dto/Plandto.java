package com.java.esop.dto;

public class Plandto {
	
	
	private String year;
	
	private String startDate;
	
	private String actualEndDate;
	
	private boolean isCurrentPlanYear;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(String actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public boolean isCurrentPlanYear() {
		return isCurrentPlanYear;
	}

	public void setCurrentPlanYear(boolean isCurrentPlanYear) {
		this.isCurrentPlanYear = isCurrentPlanYear;
	}

	@Override
	public String toString() {
		return "Plandto [year=" + year + ", startDate=" + startDate + ", actualEndDate=" + actualEndDate
				+ ", isCurrentPlanYear=" + isCurrentPlanYear + "]";
	}
	
	
	

}
