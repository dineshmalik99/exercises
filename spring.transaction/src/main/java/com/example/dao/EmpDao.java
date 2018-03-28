package com.example.dao;

import java.util.List;

import com.example.pojo.Employee;

public interface EmpDao {

	void create(Employee emp);
	
	Employee getEmployee(Integer empid);
	
	List listEmployees();
	
	void delete(Integer empid);
	
	void update(Integer empid, Integer age);
}
