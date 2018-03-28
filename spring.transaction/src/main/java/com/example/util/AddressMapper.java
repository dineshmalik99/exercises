package com.example.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.pojo.Address;

public class AddressMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address address = new Address();
		address.setPincode(rs.getInt("pincode"));
		address.setAddress(rs.getString("address"));
		return address;
	}

}
