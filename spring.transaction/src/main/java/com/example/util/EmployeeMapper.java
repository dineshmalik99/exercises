package com.example.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.pojo.Employee;

public class EmployeeMapper implements RowMapper<Employee> {
	
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {  
		Employee employee = new Employee();  
		employee.setEmpid(rs.getInt("empid"));  
		employee.setName(rs.getString("name"));  
		employee.setAge(rs.getInt("age"));  
		employee.setSalary(rs.getLong("salary"));  
		return employee;  
	}

}
