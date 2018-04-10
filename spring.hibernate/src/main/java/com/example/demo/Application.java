package com.example.demo;

import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.PersistanceConfig;
import com.example.dao.TimeTestDao;
import com.example.dao.UserDao;
import com.example.entity.TimeTest;
import com.example.entity.User;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(PersistanceConfig.class);
		User user = new User();
		user.setFname("Dinesh");
		user.setLname("Malik");
		user.setEmail("dmalik3@sapient.com");
		user.setBirthDate(getMyBirtDate());
		user.setLastUpdatedBy("test123");
		user.setCreatedDate(new Date());
		UserDao userDao = (UserDao) context.getBean("userDaoImpl");
		userDao.save(user);
		
		user = userDao.findById(user.getUserid());
		System.out.println("Age of user is : "+user.getAge());
		
		
		/*TimeTest timeTest  = new TimeTest(new Date());
		TimeTestDao timeTestDao = (TimeTestDao) context.getBean("timeTestDaoImpl");
		timeTestDao.save(timeTest);
		timeTest = timeTestDao.findById(timeTest.getTimeTestId());
		System.out.println(timeTest.toString());*/
		
	}
	
	private static Date getMyBirtDate(){
		Calendar calender = Calendar.getInstance();
		calender.set(Calendar.YEAR, 1988);
		calender.set(Calendar.MONTH, 4);
		calender.set(Calendar.DATE, 13);
		return calender.getTime();
	}
	
}
