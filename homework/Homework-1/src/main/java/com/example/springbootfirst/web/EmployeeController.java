package com.example.springbootfirst.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.springbootfirst.Employee;
import com.example.springbootfirst.EmployeeList;

@Controller
public class EmployeeController {
	
	@GetMapping("/employees/get")
	@ResponseBody
	public EmployeeList getEmployees() {
		
		String url = "http://localhost:8080/api/employees";
		
		RestTemplate restTemplate = new RestTemplate();
		
		EmployeeList response = restTemplate.getForObject(url, EmployeeList.class);
	
		return response;
		
	}
	

	@GetMapping("/employee/get")
	@ResponseBody
	public Employee getEmployee() {
		
		int employeeId = 100;
		
		String url =  "http://localhost:8080/api/employee/" + employeeId;
		
		RestTemplate restTemplate = new RestTemplate();
		Employee foundEmp = restTemplate.getForObject(url, Employee.class);
		
		return foundEmp;
		
	}
	
	@GetMapping("/employee/post")
	@ResponseBody
	public String postEmployee() {
		
		int employeeId = 103;
		
		String url = "http://localhost:8080/api/employee";
		
		Employee employee = new Employee(employeeId, "Yaşar Mutlu", 20000);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, employee, Void.class);
		
		System.out.println("Çalışanın ismi: " + employee.getEmployeeName());
		
		return "Yollanma başarılı";
		
	}
	
	@GetMapping("/employee/put")
	@ResponseBody
	public String putEmployee() {
		
		String url = "http://localhost:8080/api/employee";
		
		Employee employee = new Employee(100, "Mustafa Gümüşsoy", 15000);
		
		RestTemplate restTemplate = new RestTemplate();
		// restTemplate.put(url, new HttpEntity<Employee>(employee));
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Employee>(employee), Void.class);
		
		System.out.println("Çalışanın bilgileri güncellendi! id: "+ employee.getEmployeeId() + " isim: " 
		+ employee.getEmployeeName() + " aylık kazanç: " + employee.getMonthlySalary());
		
		
		return "Koyma Başarılı";
		
	}
	
	@GetMapping("/employee/delete")
	@ResponseBody
	public String deleteEmployee() {
		
		int employeeId = 101;
		
		String url = "http://localhost:8080/api/employee/" + employeeId;
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		
		return "Silme başarılı";
		
		
	}
	
	
	
}


