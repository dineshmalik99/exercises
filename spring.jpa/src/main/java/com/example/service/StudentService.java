package com.example.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.StudentDao;
import com.example.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	@Transactional
	public void add(Student student) {
		studentDao.persist(student);
	}
	
	@Transactional
	public void addAll(Collection<Student> students) {
		for (Student student : students) {
			studentDao.persist(student);
		}
	}

//	@Transactional(readOnly = true)
//	public List<Student> listAll() {
//		return studentDao.findAll();
//
//	}
}
