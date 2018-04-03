package com.example.db;

import org.springframework.stereotype.Component;

@Component
public class MySqlDB implements DBProperties{

	@Override
	public void getConnection() {
		System.out.println("Load Driver:");
		System.out.println("connect URL");
		System.out.println("user :");
		System.out.println("Password");
	}

}
