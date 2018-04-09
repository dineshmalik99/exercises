package com.example.dao;

import java.util.List;

import com.example.entity.User;

public interface UserDao {
	
	User findById(int id);
	void save(User user);
	List<User> findAllUsers();
}
