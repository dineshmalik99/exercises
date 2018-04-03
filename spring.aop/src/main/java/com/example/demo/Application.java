package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.configuration.DBConfiguration;
import com.example.db.MySqlDB;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(DBConfiguration.class);
		MySqlDB mySql = context.getBean(MySqlDB.class);
		mySql.getConnection();
	}
}
