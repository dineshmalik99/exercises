package com.sapient.lloyds.service.impl;

import org.junit.Assert;
import org.junit.Test;

public class LuhnAlgorithmCardValidatorTest {

	@Test
	public void testvValidateCreditCardNumberSuccess() {
		
		
		LuhnAlgorithmCardValidator obj = new LuhnAlgorithmCardValidator();
		
		Assert.assertTrue(obj.validateCreditCardNumber("12345678903555"));
		Assert.assertTrue(obj.validateCreditCardNumber("012850003580200"));
		Assert.assertTrue(obj.validateCreditCardNumber("4556737586899855"));
		
	}
	
	
	@Test
	public void testvalidateCreditCardNumberfailure() {
		LuhnAlgorithmCardValidator obj = new LuhnAlgorithmCardValidator();
		
		Assert.assertFalse(obj.validateCreditCardNumber("4556737586899955"));
		Assert.assertFalse(obj.validateCreditCardNumber("012850003589200"));
		Assert.assertFalse(obj.validateCreditCardNumber("12345678913555"));
	}

}
