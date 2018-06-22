package com.sapient.lloyds.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sapient.lloyds.dao.CardDAO;
import com.sapient.lloyds.entity.Card;
import com.sapient.lloyds.exception.CardBaseException;
import com.sapient.lloyds.model.RequestDTO;
import com.sapient.lloyds.model.ResponseDTO;
import com.sapient.lloyds.service.CardNumberValidator;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceImplTest {

	@Mock
	private CardDAO cardDao;

	@Mock
	private CardNumberValidator cardValidator;

	@InjectMocks
	private CardServiceImpl testClass;

	@Test
	public void testGetAllCards() {

		// Given
		List<Card> list = prepareCardList();
		when(cardDao.findAll()).thenReturn(list);

		// When
		List<Card> result = testClass.getAllCards();

		// Then
		assertEquals(2, result.size());

	}

	@Test
	public void testGetCard() {
		String cardNo = "012850003580200";
		// Given
		
		Card card = new Card(cardNo, "Dinesh", new BigDecimal(5000));
		when(cardDao.findById(cardNo)).thenReturn(Optional.of(card));
		// when

		Card result = testClass.getCard(card.getCardno());
		// then
		assertEquals(card, result);
	}

	@Test
	public void testAddCard() {
		// given
		String cardNo = "12345678903555";
		Card card = new Card(cardNo, "Dinesh", new BigDecimal(0));
		when(cardValidator.validateCreditCardNumber(cardNo)).thenReturn(true);
		when(cardDao.save(card)).thenReturn(card);

		// when
		Card result = testClass.addCard(card);

		// then

		assertEquals(card, result);
	}

	@Test
	public void testChargeCard() {
		// Given
		String cardNo = "12345678903555";
		RequestDTO reqDTO = new RequestDTO("12345678903555", "£1345.00");
		Card card = new Card(cardNo, "Dinesh", new BigDecimal(10000));
		when(cardDao.findById(cardNo)).thenReturn(Optional.of(card));
		
		// when
		ResponseDTO responseDTO = testClass.chargeCard(reqDTO);

		// then
		assertEquals(reqDTO.getAmount(), responseDTO.getOutstanding());
	}
	
	
	@Test(expected=CardBaseException.class) 
	public void testChargeCardFailure() {
		// Given
		String cardNo = "12345678903555";
		RequestDTO reqDTOFailure = new RequestDTO("12345678903555", "£10345");
		Card card = new Card(cardNo, "Dinesh", new BigDecimal(10000));
		when(cardDao.findById(cardNo)).thenReturn(Optional.of(card));
		
		// when
		ResponseDTO responseDTOfailure = testClass.chargeCard(reqDTOFailure);
	}

	@Test
	public void testCreditCard() {
		//Given
		String cardNo = "12345678903555";
		RequestDTO reqDTO = new RequestDTO("12345678903555", "£1500");
		Card card = new Card(cardNo, "Dinesh", new BigDecimal(10000));
		card.setOutstanding(new BigDecimal(5000));
		when(cardDao.findById(cardNo)).thenReturn(Optional.of(card));
		
		// when
		ResponseDTO responseDTO = testClass.creditCard(reqDTO);
		
		// then
		assertEquals("£3500.00", responseDTO.getOutstanding());
	}

	@Test
	public void testGetDecimalAmountFromString(){
		BigDecimal result = testClass.getDecimalAmountFromString("£123.3456");
		assertEquals(new BigDecimal("123.35"), result);
	}
	
	private List<Card> prepareCardList() {
		List<Card> list = new ArrayList<>();
		list.add(new Card("012850003580200", "Dinesh", new BigDecimal(5000)));
		list.add(new Card("12345678903555", "Deepak", new BigDecimal(3000)));
		return list;

	}
	
	

}
