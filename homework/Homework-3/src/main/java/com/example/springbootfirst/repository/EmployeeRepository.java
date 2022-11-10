package com.example.springbootfirst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.springbootfirst.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	
	@Query("select emp from Employee emp where emp.department.departmentId = :departmentId")
	List<Employee> findAllByDepartmentId(@Param("departmentId") long departmentId);

}
