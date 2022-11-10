package com.example.springbootfirst.mvc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbootfirst.entity.Employee;
import com.example.springbootfirst.repository.EmployeeRepository;

@Controller
@RequestMapping("/work")
public class EmployeeController {
	
	private EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/employee/bydepartment/{id}")
	@ResponseBody
	public String getEmployeesByDepartment(@PathVariable("id") long departmentId) {
		
		List<Employee> employees = employeeRepository.findAllByDepartmentId(departmentId);
		//System.out.println(employees.isEmpty());
		double totalSalary = 0;
		
		for(Employee emp: employees) {
			
			System.out.println(emp.getEmployeeId() + " " + emp.getEmployeeName() + " " + emp.getMonthlySalary());
			
			totalSalary += emp.getMonthlySalary();
			
		}
		
		double result = totalSalary / employees.size();
		
		return "Average Monthly Salary: " + result;
	}

}
