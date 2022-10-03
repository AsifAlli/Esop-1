package com.java.esop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import com.java.esop.appconstant.Appconstant;

/**
 * @author MURALI SANKAR
 * Class: Allocation Entity Class
 */
@Entity
@Table(name=Appconstant.ALLOCATION_INFO)
public class Allocation implements Serializable{
	
	@Id
	@GenericGenerator(name="auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="id")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Grant grant;
	
	@Column(name="allocationNumber")
	private Double allocationNumber;
	
	@Column(name="allocationDate")
	private String allocationDate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="allocationYear")
	private String allocationYear;

	public Allocation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}




	public Grant getGrant() {
		return grant;
	}

	public void setGrant(Grant grant) {
		this.grant = grant;
	}

	public Double getAllocationNumber() {
		return allocationNumber;
	}

	public void setAllocationNumber(Double allocationNumber) {
		this.allocationNumber = allocationNumber;
	}

	

	public String getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(String allocationDate) {
		this.allocationDate = allocationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAllocationYear() {
		return allocationYear;
	}

	public void setAllocationYear(String allocationYear) {
		this.allocationYear = allocationYear;
	}

	@Override
	public String toString() {
		return "Allocation [id=" + id + ", grant=" + grant + ", allocationNumber=" + allocationNumber
				+ ", allocationDate=" + allocationDate + ", status=" + status + ", allocationYear=" + allocationYear
				+ "]";
	}


	
	


	
	

}
