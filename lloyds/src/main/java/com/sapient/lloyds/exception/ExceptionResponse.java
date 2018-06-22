package com.sapient.lloyds.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timestamp;
	private String error;
	private ErrorCodes errorcode;
	

	public ExceptionResponse(){
		
	}
	
	
	public ExceptionResponse(Date timestamp, String error, ErrorCodes errorcode) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.errorcode = errorcode;
	}


	public Date getTimestamp() {
		return timestamp;
	}
	public String getError() {
		return error;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public void setError(String error) {
		this.error = error;
	}


	public ErrorCodes getErrorcode() {
		return errorcode;
	}


	public void setErrorcode(ErrorCodes errorcode) {
		this.errorcode = errorcode;
	}
	


}
