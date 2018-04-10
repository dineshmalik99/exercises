package com.example.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.example.dao.AbstractDao;
import com.example.dao.UserDao;
import com.example.entity.User;

@Transactional
@Component
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

	@Override
	public User findById(int id) {
		User user = getByKey(id);
		return user;
//		return null;
	}

	@Override
	public void save(User user) {
		persist(user);
	}

	@Override
	public List<User> findAllUsers() {
		return null;
	}

}
