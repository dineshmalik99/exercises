package com.example.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Lazy;

public class Address {
	private int pincode;
	private String address;
	@Autowired
	@Qualifier("")
	private Student student;
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student getStudent() {
		return student;
	}
//	@Required
	public void setStudent(Student student) {
		this.student = student;
	}
	
//	@Autowired
	public Address(@Lazy Student student){
		this.student = student;
	}

}
