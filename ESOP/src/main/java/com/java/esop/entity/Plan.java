package com.java.esop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.java.esop.appconstant.Appconstant;

/**
 * @author MURALI SANKAR
 * 
 * Class: Plan Entity Class
 *
 */
@Entity
@Table(name=Appconstant.PLAN_INFO)
public class Plan implements Serializable{
	
	@Id
	@GenericGenerator(name="info",strategy ="increment")
	@GeneratedValue(generator = "info")
	@Column(name="id")
	private Long id;
	
	@Column(name="year")
	private String year;
	
	@Column(name="startDate")
	private String startDate;

	@Column(name="actualEndDate")
	private String actualEndDate;
	
	@Column(name="isCurrentPlanYear")
	private boolean isCurrentPlanYear;
	
	@Column(name="vestingFactor")
	private Double vestingFactor;
	
	@Column(name="monetizationDate")
	private String monetizationDate;
	
	@Column(name="foreMarketValue")
	private Double foreMarketValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public void setMonetizationDate(String monetizationDate) {
		this.monetizationDate = monetizationDate;
	}



	public boolean isCurrentPlanYear() {
		return isCurrentPlanYear;
	}

	public String getMonetizationDate() {
		return monetizationDate;
	}

	public void setCurrentPlanYear(boolean isCurrentPlanYear) {
		this.isCurrentPlanYear = isCurrentPlanYear;
	}

	public Double getVestingFactor() {
		return vestingFactor;
	}

	public void setVestingFactor(Double vestingFactor) {
		this.vestingFactor = vestingFactor;
	}



	public Double getForeMarketValue() {
		return foreMarketValue;
	}

	public void setForeMarketValue(Double foreMarketValue) {
		this.foreMarketValue = foreMarketValue;
	}

	public Plan() {
		super();
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", year=" + year + ", startDate=" + startDate + ", actualEndDate=" + actualEndDate
				+ ", isCurrentPlanYear=" + isCurrentPlanYear + ", vestingFactor=" + vestingFactor
				+ ", monetizationDate=" + monetizationDate + ", foreMarketValue=" + foreMarketValue + "]";
	}

	
	
	
	
}
