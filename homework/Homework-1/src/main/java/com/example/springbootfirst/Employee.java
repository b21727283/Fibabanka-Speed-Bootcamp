package com.example.springbootfirst;

public class Employee {
	
	private int employeeId;
	
	private String employeeName;
	
	private int monthlySalary;

	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, int monthlySalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.monthlySalary = monthlySalary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	

}
