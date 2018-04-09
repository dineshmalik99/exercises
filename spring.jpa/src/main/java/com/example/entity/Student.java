package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int age;
	private String name;
	
	
	public Student(){
		
	}
	public Student(int age, String name){
		this.age = age;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void printDetails(){
		System.out.println("Student Name"+getName());
		System.out.println("Student Age"+getAge());
	}
}
