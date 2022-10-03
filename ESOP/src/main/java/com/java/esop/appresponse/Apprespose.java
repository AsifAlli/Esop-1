package com.java.esop.appresponse;

/**
 * @author MURALI SANKAR
 * Class : Apprespose
 */
public class Apprespose {

	public String statusCode;
	
	public String status;
	
	public Object data;
	
	public String error;

	public Apprespose() {
		super();
	}

	public Apprespose(String statusCode, String status, Object data, String error) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.data = data;
		this.error = error;
	}

	@Override
	public String toString() {
		return "Apprespose [statusCode=" + statusCode + ", status=" + status + ", data=" + data + ", error=" + error
				+ "]";
	}
	
	
	
	
	
}
