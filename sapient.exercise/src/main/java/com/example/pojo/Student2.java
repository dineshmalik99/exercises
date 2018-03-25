package com.example.pojo;

import java.util.Set;

public class Student2 {
	private int age;
	private String name;
//	@Autowired
	private Address2 address;
	private Set<String> subjects;
	
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
	public Set<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	public Address2 getAddress() {
		return address;
	}

	public void setAddress(Address2 address) {
		this.address = address;
	}

	public void printDetails(){
		System.out.println("Student Name"+getName());
		System.out.println("Student Age"+getAge());
		System.out.println("Student Address"+getAddress().getAddress());
		System.out.println("Student subjects are : "+getAddress().getAddress());
		subjects.stream().forEach((a)->{System.out.print(a+" ");});
	}
}
