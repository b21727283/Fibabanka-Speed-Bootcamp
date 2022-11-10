package com.example.springbootfirst.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootfirst.Employee;
import com.example.springbootfirst.EmployeeList;

@RestController
public class EmployeeResource {
	
	@GetMapping("/api/employees")
	public EmployeeList getEmployees(){
		
		EmployeeList employeeList = new EmployeeList();
		
		employeeList.addEmployee(new Employee(100, "Mustafa Gümüşsoy", 10000));
		employeeList.addEmployee(new Employee(101, "Eren Durmaz", 15000));
		employeeList.addEmployee(new Employee(102, "Ayşe Sevinç", 11000));
		
		return employeeList;
	
	}
	
	@GetMapping("/api/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int employeeId) {
		
		Employee foundEmp = new Employee(employeeId, "Mustafa Gümüşsoy", 10000);
		
		return foundEmp;
	
	}
	
	@PostMapping("/api/employee")
	public void postEmployee(@RequestBody Employee employee) {
		
		System.out.println("Çalışan eklendi " + employee.getEmployeeName());
		
	}
	
	@PutMapping("/api/employee")
	public void putEmployee(@RequestBody Employee employee) {
		
		System.out.println("Çalışanın bilgileri değişti id: "+ employee.getEmployeeId() + " isim: " + employee.getEmployeeName() + " aylık kazanç: " + employee.getMonthlySalary());
		
	}
	
	@DeleteMapping("/api/employee/{id}")
	public void deleteEmployee(@PathVariable("id") int employeeId) {
		
		System.out.println("Çalışan silindi " + employeeId);
		
	}
	
	
	
	
	

}
