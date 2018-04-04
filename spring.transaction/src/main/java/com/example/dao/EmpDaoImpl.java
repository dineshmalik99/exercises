package com.example.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.pojo.Employee;
import com.example.util.EmployeeMapper;

public class EmpDaoImpl extends JdbcDaoSupport implements EmpDao {

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void create(Employee emp) {
		try {
			String SQL = "INSERT INTO Employee (name, age, salary) VALUES (?, ?, ?)";
			getJdbcTemplate().update(SQL, new Object[]{emp.getName(), emp.getAge(), emp.getSalary()} );
			System.out.println("Created Record Name = " + emp.getName() + " Age = " + emp.getAge()+ " Salary = " + emp.getSalary());
			throw new RuntimeException("generating  rollback for Employee");
			// to simulate the exception.
//			try {
//				Thread.sleep(1000*10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			throw new RuntimeException("simulate Error condition");
		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			throw e;
		}
	}

	@Override
	public Employee getEmployee(Integer empid) {
		String SQL = "SELECT * FROM Employee WHERE empid = ?";
		Employee employee = (Employee) getJdbcTemplate().queryForObject(SQL, new Object[]{empid}, new EmployeeMapper());
		return employee;
	}

	@Override
	public List listEmployees() {
		String SQL = "SELECT * FROM Employee";
		List employees = (List) getJdbcTemplate().query(SQL, new EmployeeMapper());
		return employees;
	}

	@Override
	public void delete(Integer empid) {
		String SQL = "DELETE FROM Employee WHERE empid = ?";
		getJdbcTemplate().update(SQL, new Object[]{empid});
		System.out.println("Deleted Record with EMPID = " + empid );
	}

	@Override
	public void update(Integer empid, Integer age) {
		String SQL = "UPDATE Employee SET age = ? WHERE empid = ?";
		getJdbcTemplate().update(SQL, new Object[]{age, empid});
		System.out.println("Updated Record with EMPID = " + empid );
	}

}
