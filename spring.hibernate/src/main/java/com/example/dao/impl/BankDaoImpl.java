package com.example.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.dao.AbstractDao;
import com.example.dao.BankDao;
import com.example.entity.Bank;

@Repository
@Transactional
public class BankDaoImpl extends AbstractDao<Bank> implements BankDao{

	@Override
	public Bank findById(int id) {
		Bank bank = getByKey(id);
		return bank;
	}

	@Override
	public void save(Bank bank) {
		persist(bank);
	}

}
