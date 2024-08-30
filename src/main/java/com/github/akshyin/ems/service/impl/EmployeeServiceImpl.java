package com.github.akshyin.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.akshyin.ems.dto.EmployeeDto;
import com.github.akshyin.ems.entity.Employee;
import com.github.akshyin.ems.exception.ResourceNotFoundException;
import com.github.akshyin.ems.mapper.EmployeeMapper;
import com.github.akshyin.ems.repository.EmployeeRepository;
import com.github.akshyin.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}
	@Override
	public EmployeeDto getEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee savedEmployee=employeeRepository.getReferenceById(employeeId);
		if (savedEmployee==null){
			throw new ResourceNotFoundException("Employee is not found with given exception");
		}
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	
	}
	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees= employeeRepository.findAll();
		
		return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
	}
	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedemployeeDto) {
		// TODO Auto-generated method stub
		EmployeeDto  existingemployee= this.getEmployee(employeeId);
		existingemployee.setFirstname(updatedemployeeDto.getFirstname());
		existingemployee.setLastname(updatedemployeeDto.getLastname());
		existingemployee.setEmail(updatedemployeeDto.getEmail());
		return EmployeeMapper.mapToEmployeeDto( employeeRepository.save(EmployeeMapper.mapToEmployee(existingemployee)));
		
	}
	@Override
	public void deleteEmployee(Long employeeId) {
	
			// TODO Auto-generated method stub
			employeeRepository.deleteById(employeeId);
			
	
		
	}
	
	
	

}
