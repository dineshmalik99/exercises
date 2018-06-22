package com.sapient.lloyds.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sapient.lloyds.entity.Card;
import com.sapient.lloyds.model.RequestDTO;
import com.sapient.lloyds.model.ResponseDTO;
import com.sapient.lloyds.service.CardService;

@RestController
@RequestMapping("/lloyds")
public class CreditCardController {
	
	@Autowired
	CardService cardService;
	
	
	@GetMapping(path="/cards")
	public List<Card> getAllCards(){
		return cardService.getAllCards();
	}
	
	
	@GetMapping(path="/cards/{cardNumber}")
	public Card getCard(@PathVariable String cardNumber){
		return cardService.getCard(cardNumber);
	}
	
	
	@PostMapping(path="/cards")
	public ResponseEntity<Object> addCreditCard(@Valid @RequestBody Card creditCard){
		Card card = cardService.addCard(creditCard);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(card.getCardno()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping(path="/cards/charge")
	public ResponseDTO chargeCard(@RequestBody RequestDTO cardDto){
		return cardService.chargeCard(cardDto);
	}
	
	@PutMapping(path="/cards/credit")
	public ResponseDTO creditCard(@RequestBody RequestDTO cardDto){
		return cardService.creditCard(cardDto);
	}
	

}
