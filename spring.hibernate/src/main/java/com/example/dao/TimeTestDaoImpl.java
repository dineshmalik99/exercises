package com.example.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.entity.TimeTest;

@Repository
@Transactional
public class TimeTestDaoImpl extends AbstractDao<TimeTest> implements TimeTestDao{

	@Override
	public void save(TimeTest timeTest) {
		persist(timeTest);
	}

	@Override
	public TimeTest findById(int id) {
		TimeTest timetest = getByKey(id);
		return timetest;
	}

}
