package com.exception.service;

import java.util.List;

import com.exception.exception.EmployeeException;
import com.exception.model.Employee;

public interface EmployeeService {

	// Create Employee
	public Employee createEmployee(Employee employee) throws EmployeeException;
	
	// Get All Employee
	public List<Employee> getEmployee() throws EmployeeException;
	
	// Get An Employee
	public Employee getEmployee(long id) throws EmployeeException;
	
	// Update Employee
	public Employee updateEmployee(Employee employee, long id) throws EmployeeException;
	
	// Delete Employee
	public void deleteEmployee(long id) throws EmployeeException;
}
