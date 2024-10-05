package com.example.employee.service;

import java.util.List;

import com.example.employee.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto getEmployeeById(long id) throws Exception;
	
	List<EmployeeDto> getAllEmployees();
	

}
