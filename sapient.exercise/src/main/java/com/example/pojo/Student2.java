package com.example.pojo;

import java.util.Set;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student2 implements InitializingBean,DisposableBean{
	private int age;
	private String name;
	//	@Autowired
	private Address2 address;
	private Set<String> subjects;

	public Student2(){
		System.out.println("In no-arg Constructor student2");
	}

	public Student2(int age, String name){
		System.out.println("In Constructor student2");
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

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean after properties");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("InitializingBean destroy");
	}

	private void init() {
		System.out.println("In init method");
	}
	private void customDestroy() {
		System.out.println("Custom destroy");
	}
}
