package com.example.demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.PersistanceConfig;
import com.example.dao.BankDao;
import com.example.entity.Address;
import com.example.entity.Bank;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(PersistanceConfig.class);
		Bank bank = new Bank();
		bank.setName("Yes bank");
		bank.setInternational(true);
		bank.setLastUpdatedDate(new Date());
		Address address = new Address();
		address.setAddressLine1("sector 52");
		address.setAddressLine2("Adhunik Apartment");
		address.setCity("Gurgaon");
		address.setState("Haryana");
		address.setZipCode("122001");
		bank.setAddress(address);
		bank.getContacts().put("Deepak",999121212);
		bank.getContacts().put("Rahul",991004627);
		BankDao dao = context.getBean("bankDaoImpl", BankDao.class);
		dao.save(bank);
		
	}
	
}
