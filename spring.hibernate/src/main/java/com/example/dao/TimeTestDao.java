package com.example.dao;

import com.example.entity.TimeTest;

public interface TimeTestDao {
	void save(TimeTest timeTest);
	public TimeTest findById(int id);
}
