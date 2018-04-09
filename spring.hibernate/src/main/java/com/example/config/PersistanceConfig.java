package com.example.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example")
@PropertySource({"classpath:sql.properties","classpath:application.properties"})
@ComponentScan(basePackages={"com.example"})
public class PersistanceConfig {

	@Autowired
	private Environment env;


//	@Bean
//	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//		sessionFactory.setPackagesToScan("com.example");
//		sessionFactory.setHibernateProperties(hibernateProperties());
//		return sessionFactory;
//	}

	
	
//	@Bean
//	public EntityManagerFactory entityManagerFactory() {
//		
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setDatabase(Database.MYSQL);
//		vendorAdapter.setGenerateDdl(true);
//		
//		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//		emf.setDataSource(restDataSource());
//		emf.setJpaVendorAdapter(vendorAdapter);
//		emf.setPackagesToScan("com.mysource.model");
//		emf.setPersistenceUnitName("default");
//		emf.afterPropertiesSet();
//		return emf.getObject();
//	}
	
	@Bean
	public SessionFactory getSessionFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(restDataSource());
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setPackagesToScan("com.example");
		emf.setPersistenceUnitName("default");
		emf.setJpaProperties(hibernateProperties());
		emf.afterPropertiesSet();
		
	    if (emf.getObject().unwrap(SessionFactory.class) == null) {
	        throw new NullPointerException("factory is not a hibernate factory");
	    }
	    return emf.getObject().unwrap(SessionFactory.class);
	}

	//	@Bean
	//	public LocalSessionFactoryBean sessionFactory() {
	//		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
	//		EntityManagerFactory  entityManagerFactory = new Entit
	//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	//		sessionFactory.setDataSource(restDataSource());
	//		sessionFactory.setPackagesToScan(
	//				new String[] { "com.example"});
	//		sessionFactory.setHibernateProperties(hibernateProperties());
	//
	//		return sessionFactory;
	//	}

	@Bean
	public DataSource restDataSource() {
		DriverManagerDataSource dataSource = new  DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));

		return dataSource;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(
			SessionFactory sessionFactory) {

		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties hibernateProperties(){
		return new Properties(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
//				setProperty("hibernate.hbm2ddl.auto",
//						env.getProperty("hibernate.hbm2ddl.auto"));
				setProperty("hibernate.dialect",
						env.getProperty("hibernate.dialect"));
				setProperty("hibernate.show_sql",
						env.getProperty("hibernate.show_sql"));
				setProperty("hibernate.globally_quoted_identifiers",
						"true");
				setProperty("hibernate.current_session_context_class",
						env.getProperty("hibernate.current_session_context_class"));

			}};
	}

	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

}
