package com.suvidhabank.proj.repository;

import org.springframework.data.repository.CrudRepository;

import com.suvidhabank.proj.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
