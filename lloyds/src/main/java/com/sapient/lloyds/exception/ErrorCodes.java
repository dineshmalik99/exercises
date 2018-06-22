package com.sapient.lloyds.exception;

import java.text.MessageFormat;

public enum ErrorCodes {
	USER_NOT_FOUND("User for id : {0} is not valid"),
	INVALID_CARD_NUMBER("Invalid  cardNumber : {0}"),
	INVALID_CURRENCY("Invalid  currency : {0} , acceptable is only £"),
	CHARACTERS_NOT_ALLOWED("characters not allowed in cardnumber {0}"),
	EXCEEDING_ACCOUNT_BALANCE("User for id : {0} is exceeding account balance, Current balance :£{1} , limit :£{2}");

	private String errorMessage;

	ErrorCodes(String msg){
		this.errorMessage = msg;
	}

	public String getMessage() {return errorMessage ;}
	
	public String getMessage(Object... obj) { return MessageFormat.format(errorMessage,obj);}


}
