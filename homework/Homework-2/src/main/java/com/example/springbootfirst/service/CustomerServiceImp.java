package com.example.springbootfirst.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootfirst.Customer;

@Service
public class CustomerServiceImp implements CustomerService {

	@Override
	public Customer find(int customerId) {
		
		return new Customer(customerId, "mustafa", 5000);
	}

	@Override
	public List<Customer> findAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		customers.add(new Customer(1, "mustafa", 5000));
		customers.add(new Customer(2, "oguz", 3000));
		customers.add(new Customer(3, "ali", 8000));
		
		return customers;
	}

	@Override
	public void createCustomer(Customer customer) {
		
		customer.setCustomerId(4);
		
		System.out.println("Müşteri eklendi! " + customer.getCustomerId() 
		+ " " + customer.getCustomerName() 
		+ " " + customer.getTotalDebit());

	}

	@Override
	public void updateCustomer(Customer customer) {
		
		customer.setTotalDebit(6666);
		
		System.out.println("Müşteri bilgileri değişti! " + customer.getCustomerId() 
		+ " " + customer.getCustomerName() 
		+ " " + customer.getTotalDebit());
		

	}

	@Override
	public void deleteCustomer(int customerId) {
		
		Customer customer = find(customerId);
		
		System.out.println("Müşteri silindi! " + customer.getCustomerName());
		

	}

}
