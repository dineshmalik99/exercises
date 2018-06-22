package com.sapient.lloyds.model;

public class ResponseDTO {
	
	private String cardNumber;
	private String outstanding;
	
	public ResponseDTO(){
	}
	
	public ResponseDTO(String cardNumber, String outstanding) {
		super();
		this.cardNumber = cardNumber;
		this.outstanding = outstanding;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(String outstanding) {
		this.outstanding = outstanding;
	}
	

}
