package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AddressDao;
import com.example.dao.EmpDao;
import com.example.pojo.Address;
import com.example.pojo.Employee;

public class EmpMainApp {

 /**
  * @param args
  */
 public static void main(String[] args) {
	 EmpMainApp obj = new EmpMainApp();
  ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
  EmpDao empDao = (EmpDao) context.getBean("employeeDaoImpl");
  AddressDao addDao = (AddressDao) context.getBean("addressDaoImpl");
  EmployeeService empService = (EmployeeService) context.getBean("empService");
  
  System.out.println("------Records Creation--------" );
  Employee emp = new Employee();
  emp.setName("Deepak99");
  emp.setAge(29);
  emp.setSalary(19999);
   
  Address address = new Address();
  address.setAddress("Fresco Apartments5");
  address.setPincode(122001);
  try {
	  empService.saveEmployeeAndAddress(emp, address, empDao, addDao);
} catch (Exception e) {
	System.out.println("Got exception");
	e.printStackTrace();
}
//  System.out.println("------Listing Multiple Records--------" );
//  List<Employee> employees = empDao.listEmployees();
//  for (Employee employee : employees) {
//          System.out.print(employee);
//     }
 }
 

 
}