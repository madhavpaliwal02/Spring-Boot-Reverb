package com.exception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.exception.EmployeeException;
import com.exception.model.Employee;
import com.exception.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee createEmployee(Employee emp) throws EmployeeException {
		if (emp.getName() == null || emp.getDesignation() == null || emp.getSalary() == 0 || emp.getCompany() == null)
			throw new EmployeeException("Invalid input value for register !");

		for (Employee e : this.employeeRepo.findAll())
			if (e.getName().equals(emp.getName()) && e.getDesignation().equals(emp.getDesignation())
					&& e.getCompany().equals(emp.getCompany()))
				throw new EmployeeException("Employee already exists");

		System.out.println(emp);
		return this.employeeRepo.save(emp);
	}

	@Override
	public List<Employee> getEmployee() throws EmployeeException {
		List<Employee> list = this.employeeRepo.findAll();
		if (list.size() == 0)
			throw new EmployeeException("No Employee found");
		return list;
	}

	@Override
	public Employee getEmployee(long id) throws EmployeeException {
		return this.employeeRepo.findById(id)
				.orElseThrow(() -> new EmployeeException("Employee not exists with given id:" + id));
	}

	@Override
	public Employee updateEmployee(Employee emp, long id) throws EmployeeException {
		if (emp.getName() == null || emp.getDesignation() == null || emp.getSalary() == 0 || emp.getCompany() == null)
			throw new EmployeeException("Invalid input value for update !");

		for (Employee e : getEmployee())
			if (e.getName().equals(emp.getName()) && e.getDesignation().equals(emp.getDesignation())
					&& e.getCompany().equals(emp.getCompany()) && e.getId() != id)
				throw new EmployeeException("Employee already exists with duplicate values");

		emp.setId(id);
		return this.employeeRepo.save(emp);
	}

	@Override
	public void deleteEmployee(long id) throws EmployeeException {
		Employee old = this.employeeRepo.findById(id)
				.orElseThrow(() -> new EmployeeException("Employee can't be deleted with given id"));
		this.employeeRepo.delete(old);
	}

}
