package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.pojo.Student;

@Configuration
@ComponentScan(basePackages = { "com.example" })
public class SampleConfiguration {
	
	@Bean
	Student getStudentBean(){
		Student student = new Student();
		student.setName("Deepak");
		student.setAge(30);
//		student.setAddress(address);
		return student;
		
	}
	
//	@Bean
//	Address getAddress(){
//		Address addr = new Address();
//		addr.setPincode(122003);
//		addr.setAddress("Fresco society");
//		return addr;
//	}
	
//	@Bean
//	Address getAddress2(){
//		Address addr = new Address();
//		addr.setPincode(110011);
//		addr.setAddress("Charmwood Village");
//		return addr;
//	}

}
