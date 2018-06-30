package com.doitgeek.springdemo.service;

import java.util.List;

import com.doitgeek.springdemo.entity.Customer;

public interface CustomerService {
	List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomer(Integer id);
	void deleteCustomer(Integer id);
}
