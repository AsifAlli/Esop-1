package com.java.esop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.java.esop.appconstant.Appconstant;

/**
 * @author MURALI SANKAR
 * Class: Grant Entity Class
 *
 */
@Entity
@Table(name=Appconstant.GRANT_INFO)
public class Grant implements Serializable{
	
	@Id
	@GenericGenerator(name="info",strategy ="increment")
	@GeneratedValue(generator = "info")
	@Column(name="id")
	private Long id;
	

	
	@Column(name="grantId")
	private String grantId;
	
	@Column(name="employeeNumber")
	private String employeeNumber;
	
	@Column(name="brand")
	private String brand;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Plan plan;
	
	@Column(name="numberOfGrante")
	private Long numberOfGrante;
	
	@Column(name="grantPrice")
	private  Double grantPrice;
	
	@Column(name="grantStatus")
	private String grantStatus;
	
	@Column(name="acceptedDate")
	private Date acceptedDate;
	
	@Column(name="grantedDate")
	private Date grantedDate;
	
	@Column(name="accepted")
	private boolean accepted;
	
	@Column(name="allocatinStatus")
	private boolean allocatinStatus;

	
	public Grant() {
		super();
	}

	
	
	public Plan getPlan() {
		return plan;
	}



	public void setPlan(Plan plan) {
		this.plan = plan;
	}



	public boolean isAllocatinStatus() {
		return allocatinStatus;
	}


	public void setAllocatinStatus(boolean allocatinStatus) {
		this.allocatinStatus = allocatinStatus;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrantId() {
		return grantId;
	}

	public void setGrantId(String grantId) {
		this.grantId = grantId;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Long getNumberOfGrante() {
		return numberOfGrante;
	}

	public void setNumberOfGrante(Long numberOfGrante) {
		this.numberOfGrante = numberOfGrante;
	}

	public Double getGrantPrice() {
		return grantPrice;
	}

	public void setGrantPrice(Double grantPrice) {
		this.grantPrice = grantPrice;
	}

	public String getGrantStatus() {
		return grantStatus;
	}

	public void setGrantStatus(String grantStatus) {
		this.grantStatus = grantStatus;
	}

	public Date getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public Date getGrantedDate() {
		return grantedDate;
	}

	public void setGrantedDate(Date grantedDate) {
		this.grantedDate = grantedDate;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}



	@Override
	public String toString() {
		return "Grant [id=" + id + ", grantId=" + grantId + ", employeeNumber=" + employeeNumber + ", brand=" + brand
				+ ", plan=" + plan + ", numberOfGrante=" + numberOfGrante + ", grantPrice=" + grantPrice
				+ ", grantStatus=" + grantStatus + ", acceptedDate=" + acceptedDate + ", grantedDate=" + grantedDate
				+ ", accepted=" + accepted + ", allocatinStatus=" + allocatinStatus + "]";
	}
	

}
