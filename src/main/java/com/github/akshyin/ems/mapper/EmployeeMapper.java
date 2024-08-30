package com.github.akshyin.ems.mapper;

import com.github.akshyin.ems.dto.EmployeeDto;
import com.github.akshyin.ems.entity.Employee;

public class EmployeeMapper {

		public static EmployeeDto mapToEmployeeDto(Employee employee) {
			return new EmployeeDto(
					
					employee.getId(),
					employee.getFirstname(),
					employee.getLastname(),
					employee.getEmail()
					
					);
		}
		public static Employee mapToEmployee(EmployeeDto employeedto) {
			return new Employee(employeedto.getId(),employeedto.getFirstname(),employeedto.getLastname(),employeedto.getEmail());
		}
	
}
