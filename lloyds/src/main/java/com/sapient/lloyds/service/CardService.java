package com.sapient.lloyds.service;

import java.util.List;

import com.sapient.lloyds.entity.Card;
import com.sapient.lloyds.model.RequestDTO;
import com.sapient.lloyds.model.ResponseDTO;

public interface CardService {

	List<Card> getAllCards();
	
	Card getCard(String cardNumber);
	
	Card addCard(Card card);

	ResponseDTO chargeCard(RequestDTO cardDto);
	
	ResponseDTO creditCard(RequestDTO cardDto);
	
}
