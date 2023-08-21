package com.exception.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exception.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
