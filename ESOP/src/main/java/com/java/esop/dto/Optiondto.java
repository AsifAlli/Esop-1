package com.java.esop.dto;

public class Optiondto {
	

	private String grantId;
	
	private Double allocatedSum;
	
	private String empNumber;
	
	private Long planId;

	public Optiondto(String grantId, Double allocatedSum, String empNumber, Long planId) {
		super();
		this.grantId = grantId;
		this.allocatedSum = allocatedSum;
		this.empNumber = empNumber;
		this.planId = planId;
	}

	public String getGrantId() {
		return grantId;
	}

	public void setGrantId(String grantId) {
		this.grantId = grantId;
	}

	public Double getAllocatedSum() {
		return allocatedSum;
	}

	public void setAllocatedSum(Double allocatedSum) {
		this.allocatedSum = allocatedSum;
	}

	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	
	
	
	
	
	
}
