package com.exception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.exception.EmployeeException;
import com.exception.model.Employee;
import com.exception.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	// Create Employee
	@PostMapping
	public ResponseEntity<Employee> createEmployeeHandler(@RequestBody Employee employee) throws EmployeeException {
		Employee emp = this.empService.createEmployee(employee);
		System.out.println(employee);
		return new ResponseEntity<>(emp, HttpStatus.CREATED);
	}

	// Get All Employees
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployeeHandler() throws EmployeeException {
		List<Employee> list = this.empService.getEmployee();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// Get an Employee
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeHandler(@PathVariable long id) throws EmployeeException {
		Employee emp = this.empService.getEmployee(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	// Update an Employee
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeeHandler(@RequestBody Employee emp, @PathVariable long id)
			throws EmployeeException {
		Employee newEmp = this.empService.updateEmployee(emp, id);
		return new ResponseEntity<>(newEmp, HttpStatus.ACCEPTED);
	}

	// Delete an Employee
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployeeHandler(@PathVariable long id) throws EmployeeException {
		this.empService.deleteEmployee(id);
		return new ResponseEntity<>("Successfully Deleted !", HttpStatus.OK);
	}
}
