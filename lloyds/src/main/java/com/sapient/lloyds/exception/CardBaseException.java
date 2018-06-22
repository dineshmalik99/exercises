package com.sapient.lloyds.exception;

public class CardBaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorCodes errorCode;
	public CardBaseException(String message,  ErrorCodes errorCode){
		super(message);
		this.errorCode = errorCode;
	}
	public ErrorCodes getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
