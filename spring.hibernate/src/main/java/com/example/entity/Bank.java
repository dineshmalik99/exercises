package com.example.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="bank")
public class Bank {
	
	@Id
	@GeneratedValue
	private long bankId;
	private String name;
	private boolean isInternational;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedDate;
	
	@Embedded
	private Address address;
	
	@ElementCollection
	@CollectionTable(name = "bankContacts", joinColumns= @JoinColumn(name="bankId"))
	@MapKeyColumn
	Map<String,Integer> contacts = new HashMap<>();
	
	public long getBankId() {
		return bankId;
	}
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isInternational() {
		return isInternational;
	}
	public void setInternational(boolean isInternational) {
		this.isInternational = isInternational;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Map<String, Integer> getContacts() {
		return contacts;
	}
	public void setContacts(Map<String, Integer> contacts) {
		this.contacts = contacts;
	}
	
	

}
