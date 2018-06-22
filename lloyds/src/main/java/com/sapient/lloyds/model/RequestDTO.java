package com.sapient.lloyds.model;

public class RequestDTO {
	
	private String cardNumber;
	private String amount;
	
	public RequestDTO(){
	}
	
	public RequestDTO(String cardNumber, String amount) {
		super();
		this.cardNumber = cardNumber;
		this.amount = amount;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

}
