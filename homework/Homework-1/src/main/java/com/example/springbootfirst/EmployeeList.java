package com.example.springbootfirst;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private List<Employee> employees;
    private int counter = 3;

    public EmployeeList() {
        employees = new ArrayList<>();
    }

	public List<Employee> getEmployees() {
		return employees;
	}

	public void addEmployee(Employee emp) {
		employees.add(emp);
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
    


}