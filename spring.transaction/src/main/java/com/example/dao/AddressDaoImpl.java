package com.example.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.example.pojo.Address;

public class AddressDaoImpl extends JdbcDaoSupport implements AddressDao {

	@Override
	public void insertAddress(Address address) {
		try{
		String sql = "INSERT INTO Address (pincode, address) VALUES (?, ?)";
		getJdbcTemplate().update(sql,new Object[]{address.getPincode(),address.getAddress()});
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateAddress() {
		
	}

}
