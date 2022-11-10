package com.example.springbootfirst.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long departmentId;
	
	private String depatmentName;
	
	@OneToMany(mappedBy="department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Employee> employees;

	public Department() {
		super();
	}

	public Department(String depatmentName) {
		super();
		this.depatmentName = depatmentName;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepatmentName() {
		return depatmentName;
	}

	public void setDepatmentName(String depatmentName) {
		this.depatmentName = depatmentName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	

}
