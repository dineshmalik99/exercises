package com.example.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.pojo.Address;

public class AddressDaoImpl extends JdbcDaoSupport implements AddressDao {

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertAddress(Address address) {
//		try{
		String sql = "INSERT INTO Address (pincode, address) VALUES (?, ?)";
		getJdbcTemplate().update(sql,new Object[]{address.getPincode(),address.getAddress()});
		throw new RuntimeException("generating  rollback for address");
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
	}

	@Override
	public void updateAddress() {
		
	}

}
