package com.example.springbootfirst.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springbootfirst.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>{

}
