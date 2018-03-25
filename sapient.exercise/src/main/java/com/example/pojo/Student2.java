package com.example.pojo;

public class Student2 {
	private int age;
	private String name;
//	@Autowired
	private Address address;
	
	public Student2(){
	}
	
	public Student2(int age, String name){
		this.age = age;
		this.name = name;
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
