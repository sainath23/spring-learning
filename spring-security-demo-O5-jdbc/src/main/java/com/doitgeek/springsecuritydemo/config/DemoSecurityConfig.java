package com.doitgeek.springsecuritydemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Add our user for in memory authentication
		
		/*UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("john").password("john").roles("EMPLOYEE"))
										.withUser(users.username("sainath").password("sainath").roles("EMPLOYEE", "MANAGER"))
										.withUser(users.username("saurabh").password("saurabh").roles("EMPLOYEE", "ADMIN"));*/
		
		// User JDBC authentication
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
								.antMatchers("/").hasRole("EMPLOYEE")
								.antMatchers("/leaders/**").hasRole("MANAGER")
								.antMatchers("/systems/**").hasRole("ADMIN")
								.and()
								.formLogin()
								.loginPage("/show-login-page")
								.loginProcessingUrl("/authenticate-user")
								.permitAll()
								.and()
								.logout()
								.permitAll()
								.and()
								.exceptionHandling()
								.accessDeniedPage("/access-denied");
	}
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(dataSource);
		return jdbcUserDetailsManager;
	}
	
}
