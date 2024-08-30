package com.github.akshyin.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.akshyin.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
