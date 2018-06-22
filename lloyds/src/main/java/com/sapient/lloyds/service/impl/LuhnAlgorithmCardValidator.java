package com.sapient.lloyds.service.impl;

import org.springframework.stereotype.Component;

import com.sapient.lloyds.exception.CardBaseException;
import com.sapient.lloyds.exception.ErrorCodes;
import com.sapient.lloyds.service.CardNumberValidator;

@Component
public class LuhnAlgorithmCardValidator implements CardNumberValidator {
	
	@Override
	public boolean validateCreditCardNumber(String str) {

		int[] ints = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			try{
				ints[i] = Integer.parseInt(str.substring(i, i + 1));
			}
			catch(NumberFormatException e){
				String message  = ErrorCodes.CHARACTERS_NOT_ALLOWED.getMessage(str);
				throw new CardBaseException(message, ErrorCodes.CHARACTERS_NOT_ALLOWED);
			}
		}
		for (int i = ints.length - 2; i >= 0; i = i - 2) {
			int j = ints[i];
			j = j * 2;
			if (j > 9) {
				j = j % 10 + 1;
			}
			ints[i] = j;
		}
		int sum = 0;
		for (int i = 0; i < ints.length; i++) {
			sum += ints[i];
		}
		if (sum % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
