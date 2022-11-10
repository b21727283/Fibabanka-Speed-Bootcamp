package com.example.springbootfirst.resource;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootfirst.Customer;
import com.example.springbootfirst.service.CustomerService;

@RestController
public class CustomerResource {
	
	private CustomerService customerService;

	public CustomerResource(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/api/customers")
	public List<Customer> getCustomers() {
		
		return customerService.findAll();
	}
	
	@GetMapping("/api/customer/{id}")
	public Customer getCustomer(@PathVariable("id") int customerId) {
		
		return customerService.find(customerId);
		
	}
	
	@PostMapping("/api/customer")
	public void postCustomer(@RequestBody Customer customer) {
		
		customerService.createCustomer(customer);
	}
	
	@PutMapping("/api/customer")
	public void putCustomer(@RequestBody Customer customer) {
		
		customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/api/customer/{id}")
	public void deleteCustomer(@PathVariable("id") int customerId) {
		
		customerService.deleteCustomer(customerId);
		
	}
	
	
	
	
	

}
