package com.doitgeek.springdemo.dao;

import java.util.List;

import com.doitgeek.springdemo.entity.Customer;

public interface CustomerDAO {
	List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomer(Integer id);
	void deleteCustomer(Integer id);
}
