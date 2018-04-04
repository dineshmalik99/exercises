package com.example.demo;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AddressDao;
import com.example.dao.EmpDao;
import com.example.pojo.Address;
import com.example.pojo.Employee;

public class EmployeeService {

	 @Transactional(propagation=Propagation.REQUIRED)
	 public  void saveEmployeeAndAddress(Employee emp , Address address,EmpDao empDao, AddressDao addDao) throws Exception{
//		 int number = (int) (Math.random()*20);
//		 System.out.println("number "+number);
		 try{
		 empDao.create(emp);
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 Thread.sleep(1000*5);
		 addDao.insertAddress(address);
		 
	 }
}
