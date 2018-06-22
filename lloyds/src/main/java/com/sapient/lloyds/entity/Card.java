package com.sapient.lloyds.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Card {
	
	@Id
	@Size(min=14,max=19)
	@Column(nullable=false,unique=true)
	private String cardno;
	
	@Size(min=4)
	private String name;
	
	private BigDecimal cardlimit;
	
	private BigDecimal outstanding;
	
	public BigDecimal getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(BigDecimal outstanding) {
		this.outstanding = outstanding;
	}

	public Card(){
	}

	public Card(@Size(min = 14, max = 19) String cardno, @Size(min = 4) String name, BigDecimal cardlimit) {
		super();
		this.cardno = cardno;
		this.name = name;
		this.cardlimit = cardlimit;
		this.outstanding= new BigDecimal(0.0);
	}


	public String getCardno() {
		return cardno;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getCardlimit() {
		return cardlimit;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCardlimit(BigDecimal cardlimit) {
		this.cardlimit = cardlimit;
	}
	
	
}
