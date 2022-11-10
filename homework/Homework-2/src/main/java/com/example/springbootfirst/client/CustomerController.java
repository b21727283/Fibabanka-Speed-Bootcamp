package com.example.springbootfirst.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.springbootfirst.Customer;

@Controller
public class CustomerController {
	
	@GetMapping("/customer/get")
	@ResponseBody
	public String getCustomer() {
		
		int customerId = 1;
		
		String url = "http://localhost:8080/api/customer/" + customerId;
		
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(url, Customer.class);
		
		return "Müşteri: " + customer.getCustomerName() + " Toplam borç: " + customer.getTotalDebit();
	}
	
	@GetMapping("/customer/post")
	@ResponseBody
	public String postCustomer() {
		
		String url = "http://localhost:8080/api/customer";
		
		Customer customer = new Customer(5, "ayşe", 15000);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, customer, Void.class);
		
		return "Yollanma başarılı";
				
	}
	
	
	@GetMapping("/customer/put")
	@ResponseBody
	public String putCustomer() {
		
		String url = "http://localhost:8080/api/customer";
		
		Customer customer = new Customer(5, "ayşe", 15000);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(url, customer);
		
		return "Koyma başarılı";
				
	}
	
	@GetMapping("/customer/delete")
	@ResponseBody
	public String deleteCustomer() {
		
		int customerId = 1;
		
		String url = "http://localhost:8080/api/customer/"  + customerId;
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		
		return "Silme başarılı";
				
	}
	
	
	

}
