package com.example.springbootfirst.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbootfirst.entity.Department;
import com.example.springbootfirst.entity.Employee;
import com.example.springbootfirst.repository.DepartmentRepository;

@Controller
@RequestMapping("/work")
public class DepartmentController {
	
	private DepartmentRepository departmentRepository;

	public DepartmentController(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}
	
	@GetMapping("/department/insert")
	@ResponseBody
	public String insertDeparment() {
		
		Department dep1 = new Department("IT");
		
		dep1.setEmployees(new ArrayList<Employee>());
		
		Employee emp1 = new Employee("Mustafa", 15000);
		emp1.setDepartment(dep1);
		dep1.getEmployees().add(emp1);
		
		
		Employee emp2 = new Employee("Ayşe", 19000);
		emp2.setDepartment(dep1);
		dep1.getEmployees().add(emp2);
		
		
		Employee emp3 = new Employee("Veli", 12000);
		emp3.setDepartment(dep1);
		dep1.getEmployees().add(emp3);
		
		departmentRepository.save(dep1);
		
		return "Sokuldu: " + dep1.getDepartmentId();
		
	}
	
	@GetMapping("/department/delete/{id}")
	@ResponseBody
	public String deleteDepartment(@PathVariable("id") long departmentId) {
		
		departmentRepository.deleteById(departmentId);
		
		return "Silindi: id: " + Long.toString(departmentId);
		
		
	}

}
