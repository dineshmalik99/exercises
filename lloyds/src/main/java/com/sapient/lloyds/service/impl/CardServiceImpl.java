package com.sapient.lloyds.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.lloyds.dao.CardDAO;
import com.sapient.lloyds.entity.Card;
import com.sapient.lloyds.exception.CardBaseException;
import com.sapient.lloyds.exception.ErrorCodes;
import com.sapient.lloyds.model.RequestDTO;
import com.sapient.lloyds.model.ResponseDTO;
import com.sapient.lloyds.service.CardNumberValidator;
import com.sapient.lloyds.service.CardService;

@Service
@Transactional
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardDAO cardDao;
	
	@Autowired
	CardNumberValidator cardValidator;

	@Override
	public List<Card> getAllCards() {
		return cardDao.findAll();
	}

	@Override
	public Card getCard(String cardNumber) {
		Optional<Card> card =  cardDao.findById(cardNumber);
		if(card.isPresent()){
			return card.get();
		}
		String message  = ErrorCodes.USER_NOT_FOUND.getMessage(cardNumber);
		throw new CardBaseException(message,ErrorCodes.USER_NOT_FOUND);
	}

	@Override
	public Card addCard(Card card) {
		boolean isVaild = cardValidator.validateCreditCardNumber(card.getCardno());
		if(isVaild){
			 return cardDao.save(card);
		}
		else{
			String message  = ErrorCodes.USER_NOT_FOUND.getMessage(card.getCardno());
			throw new CardBaseException(message,ErrorCodes.INVALID_CARD_NUMBER);
		}
	}

	@Override
	public ResponseDTO chargeCard(RequestDTO cardDto) {
		Optional<Card> card =  cardDao.findById(cardDto.getCardNumber());
		if(card.isPresent()){
			BigDecimal limit = card.get().getCardlimit();
			BigDecimal outstanding = card.get().getOutstanding();
			BigDecimal amount = getDecimalAmountFromString(cardDto.getAmount());
			if(outstanding.add(amount).compareTo(limit)>0){
				String message  = ErrorCodes.EXCEEDING_ACCOUNT_BALANCE.getMessage(card.get().getCardno(),outstanding,limit);
				throw new CardBaseException(message, ErrorCodes.EXCEEDING_ACCOUNT_BALANCE);
			}
			else{
				outstanding = outstanding.add(amount);
				card.get().setOutstanding(outstanding);
				cardDao.flush();
				return new ResponseDTO(cardDto.getCardNumber(),"£"+outstanding.toString()); 
			}
			
		}
		else{
		String message  = ErrorCodes.USER_NOT_FOUND.getMessage(cardDto.getCardNumber());
		throw new CardBaseException(message,ErrorCodes.USER_NOT_FOUND);
		}
	}

	@Override
	public ResponseDTO creditCard(RequestDTO cardDto) {
		Optional<Card> card =  cardDao.findById(cardDto.getCardNumber());
		if(card.isPresent()){
				
				BigDecimal outstanding = card.get().getOutstanding();
				BigDecimal amount = getDecimalAmountFromString(cardDto.getAmount());
				outstanding = outstanding.subtract(amount);
				card.get().setOutstanding(outstanding);
				cardDao.flush();
				return new ResponseDTO(cardDto.getCardNumber(),"£"+outstanding.toString()); 
		}
		else{
		String message  = ErrorCodes.USER_NOT_FOUND.getMessage(cardDto.getCardNumber());
		throw new CardBaseException(message,ErrorCodes.USER_NOT_FOUND);
		}
	}
	
	public BigDecimal getDecimalAmountFromString(String amount){
		Number number;
		try {
			number = NumberFormat.getCurrencyInstance(Locale.UK).parse(amount);
		} catch (ParseException e) {
			String message  = ErrorCodes.INVALID_CURRENCY.getMessage(amount);
			throw new CardBaseException(message, ErrorCodes.INVALID_CURRENCY);
		}
		return new BigDecimal(number.toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	

}
