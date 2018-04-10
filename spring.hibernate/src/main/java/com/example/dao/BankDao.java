package com.example.dao;

import com.example.entity.Bank;

public interface BankDao {
	Bank findById(long id);
	void save(Bank user);

}
