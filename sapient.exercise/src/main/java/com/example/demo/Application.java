package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.configuration.SampleConfiguration;
import com.example.pojo.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(SampleConfiguration.class);
		Student student =  (Student) context.getBean("getStudentBean");
		System.out.println(student.getAge());
	}
}
