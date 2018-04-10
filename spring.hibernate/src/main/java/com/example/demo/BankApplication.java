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
		
		Address addresshome = new Address();
		addresshome.setAddressLine1("sector 52");
		addresshome.setAddressLine2("Adhunik Apartment");
		addresshome.setCity("Gurgaon");
		addresshome.setState("Haryana");
		addresshome.setZipCode("122001");
		
		Address addressOffc = new Address();
		addressOffc.setAddressLine1("sector 21");
		addressOffc.setAddressLine2("unitech Infospace");
		addressOffc.setCity("Gurgaon");
		addressOffc.setState("Haryana");
		addressOffc.setZipCode("122002");
		
		bank.getAddress().add(addresshome);
		bank.getAddress().add(addressOffc);
		bank.getContacts().put("Deepak",999121212);
		bank.getContacts().put("Rahul",991004627);
		BankDao dao = context.getBean("bankDaoImpl", BankDao.class);
		dao.save(bank);
		
		Bank getObj = dao.findById(bank.getBankId());
		System.out.println(getObj.getName());
		
		getObj.getAddress().stream().forEach((a)->System.out.println(a.getAddressLine1()));
		System.out.println(getObj.getName());
		getObj.getContacts().keySet().stream().forEach(
				(a)->System.out.println("contact is "+getObj.getContacts().get(a)));
		System.out.println(getObj.getName());
	
		
	}
	
}
