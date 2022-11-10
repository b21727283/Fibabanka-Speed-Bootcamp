package com.example.springbootfirst.service;

import java.util.List;

import com.example.springbootfirst.Customer;

public interface CustomerService {
	
	Customer find(int customerId);
	
	List<Customer> findAll();
	
	public void createCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(int customerId);
	
}
