package com.example.demo;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AddressDao;
import com.example.dao.EmpDao;
import com.example.pojo.Address;
import com.example.pojo.Employee;

public class EmployeeService {

	 @Transactional(propagation=Propagation.REQUIRES_NEW)
	 public  void saveEmployeeAndAddress(Employee emp , Address address,EmpDao empDao, AddressDao addDao) throws Exception{
		 int number = (int) (Math.random()*20);
		 System.out.println("number "+number);
		 empDao.create(emp);
		 Thread.sleep(1000*10);
		 if(number>10){
			 System.out.println("Rolling back for"+emp.getName()+", for address : "+address.getAddress());
			 throw new RuntimeException("generating test case of rollback");
		 }
		 addDao.insertAddress(address);
		 
	 }
}
