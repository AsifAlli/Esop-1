package com.java.esop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.java.esop.appconstant.Appconstant;

/**
 * @author MURALI SANKAR
 * Class : Employee Entity Class
 *
 */
@Entity
@Table(name=Appconstant.EMPLOYEE_INFO)
public class Employee implements Serializable{

	@Id
	@GenericGenerator(name="info",strategy ="increment")
	@GeneratedValue(generator = "info")
	@Column(name="id")
	private Long id;
	
	
	@Column(name="employeeNumber")
	private String employeeNumber;
	
	@Column(name="fullName")
	private String fullName;
	
	@Column(name="emailId")
	private String emailId;
	
	@Column(name="band")
	private String band;
	
	@Column(name="location")
	private String location;
	
	@Column(name="employeeStatus")
	private String employeeStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeNumber=" + employeeNumber + ", fullName=" + fullName + ", emailId="
				+ emailId + ", band=" + band + ", location=" + location + ", employeeStatus=" + employeeStatus + "]";
	}
	
	
	
}
