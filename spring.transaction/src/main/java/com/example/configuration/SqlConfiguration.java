package com.example.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SqlConfiguration {
	
	public PlatformTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
		
	}
	public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }
}
