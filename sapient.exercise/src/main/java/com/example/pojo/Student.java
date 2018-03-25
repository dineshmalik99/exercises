package com.example.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private int age;
	private String name;
//	@Autowired
	private Address address;
	
	@Autowired
	public Student(){
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
//	@Required
	public void setAddress(Address address) {
		this.address = address;
	}
	public void printDetails(){
		System.out.println("Student Name"+getName());
		System.out.println("Student Age"+getAge());
		System.out.println("Student Address"+getAddress().getAddress());
	}
}
