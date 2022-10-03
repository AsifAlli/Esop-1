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

@Entity
@Table(name=Appconstant.VESTED_OPTION_INFO)
public class VestedOption implements Serializable{
	
	@Id
	@GenericGenerator(name="auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private Long id;
	
	@Column(name="grantId")
	private String grantId;
	
	@Column(name="VestedOption")
	private Double VestedOption;
	
	@Column(name="createdDate")
	private Date createdDate;
	
	@Column(name="motifiedDate")
	private Date motifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Double getVestedOption() {
		return VestedOption;
	}

	public void setVestedOption(Double vestedOption) {
		VestedOption = vestedOption;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getMotifiedDate() {
		return motifiedDate;
	}

	public void setMotifiedDate(Date motifiedDate) {
		this.motifiedDate = motifiedDate;
	}

	public VestedOption() {
		super();
	}


	public String getGrantId() {
		return grantId;
	}

	public void setGrantId(String grantId) {
		this.grantId = grantId;
	}

	@Override
	public String toString() {
		return "VestedOption [id=" + id + ", grantId=" + grantId + ", VestedOption=" + VestedOption + ", createdDate="
				+ createdDate + ", motifiedDate=" + motifiedDate + "]";
	}
	
	
	

}
