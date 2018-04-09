package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Student;

@Component
public class StudentDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Student student){
		em.persist(student);
	}
	
	public List<Student> findAll(){
		return em.createQuery("Select s from Student s").getResultList();
	}
	
}
