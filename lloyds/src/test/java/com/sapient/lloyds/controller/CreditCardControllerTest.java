package com.sapient.lloyds.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sapient.lloyds.entity.Card;
import com.sapient.lloyds.service.CardService;


public class CreditCardControllerTest extends AbstractControllerTest{

	@Mock 
	private CardService cardService;
	
	@InjectMocks
	private CreditCardController testClass;
	
	private URI URI_PATH;
	

	@Before
	public void set() {
		super.setUp(testClass);

	}
	
	@Test
	public void testGetAllCards() throws Exception {
		//Given
		List<Card> list = prepareCardList();
		when(cardService.getAllCards()).thenReturn(list);
		URI_PATH = new URI("/lloyds/cards");
		// When
			
		final MvcResult result = mvc.perform(MockMvcRequestBuilders.get(URI_PATH).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		//Then 
		assertEquals(200, result.getResponse().getStatus());
		
		
	}
	
	private List<Card> prepareCardList() {
		List<Card> list = new ArrayList<>();
		list.add(new Card("012850003580200", "Dinesh", new BigDecimal(5000)));
		list.add(new Card("12345678903555", "Deepak", new BigDecimal(3000)));
		return list;

	}
	
	
}
