package com.java.esop.dto;

/**
 * @author MURALI SANKAR
 *
 *Class :  Grantdto class
 */
public class Grantdto {
	
	private String grantId;
	
	private String employeeNumber;
	
	private Long planid;
	
	private String band;
	
	private Long numberofGrante;
	
	private Double grantePrice;

	public Grantdto() {
		super();
	}

	public String getGrantId() {
		return grantId;
	}

	public void setGrantId(String grantId) {
		this.grantId = grantId;
	}



	public Long getPlanid() {
		return planid;
	}

	public void setPlanid(Long planid) {
		this.planid = planid;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public Long getNumberofGrante() {
		return numberofGrante;
	}

	public void setNumberofGrante(Long numberofGrante) {
		this.numberofGrante = numberofGrante;
	}

	public Double getGrantePrice() {
		return grantePrice;
	}

	public void setGrantePrice(Double grantePrice) {
		this.grantePrice = grantePrice;
	}

	@Override
	public String toString() {
		return "Grantdto [grantId=" + grantId + ", employeeNumber=" + employeeNumber + ", planid=" + planid + ", band="
				+ band + ", numberofGrante=" + numberofGrante + ", grantePrice=" + grantePrice + "]";
	}

    
	
	
	

}
