package com.doitgeek.springformdemo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = "com.doitgeek.springformdemo.config")
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
public class HibernateConfig {

	@Autowired
	private Environment env;

	// Configuring DataSource Bean
	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(env.getProperty("hibernate.connection.driver_class"));
		dataSource.setJdbcUrl(env.getProperty("hibernate.connection.url"));
		dataSource.setUser(env.getProperty("hibernate.connection.username"));
		dataSource.setPassword(env.getProperty("hibernate.connection.password"));
		//dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		//dataSource.setMinPoolSize(getIntProperty("hibernate.c3p0.min_size"));
		//dataSource.setMaxPoolSize(getIntProperty("hibernate.c3p0.max_size"));
		//dataSource.setMaxIdleTime(getIntProperty("hibernate.c3p0.timeout"));
		return dataSource;
	}

	// Helper method to read environ property to convert to int
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}
	
	// Configuring SessionFactory Bean
	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionFactoryBuilder.addProperties(getHibernateProperties());
		sessionFactoryBuilder.scanPackages("com.doitgeek.springformdemo.entity");
		return sessionFactoryBuilder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.dialect"));
		return properties;
	}
	
	// Configuring HibernateTransactionManager Bean
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
