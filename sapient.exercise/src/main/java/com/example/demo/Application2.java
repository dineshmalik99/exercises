package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.example.pojo.Student2;

@SpringBootApplication
public class Application2 {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		Student2 student =  (Student2) context.getBean("scienceStudent");
//		System.out.println(student.getAge());
		student.printDetails();
	}
}
