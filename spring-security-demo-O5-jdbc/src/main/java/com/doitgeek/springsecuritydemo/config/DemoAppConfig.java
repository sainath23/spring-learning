package com.doitgeek.springsecuritydemo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.doitgeek.springsecuritydemo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	// Setup variable to hold the properties
	@Autowired
	private Environment env;
	
	// Setup logger
	private Logger logger = Logger.getLogger(getClass().getName());

	// Define bean for view resolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// Define a bean for our security datasource
	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		
		// Create connection pool
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		// Set JDBC driver class
		dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		
		// log the connection props
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));
		
		// set database connection props
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return dataSource;
	}
	
	// Helper method to read environ property to convert to int
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}
}
