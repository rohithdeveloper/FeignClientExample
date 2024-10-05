package com.example.employee.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.model.Employee;

public class UserMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {

		EmployeeDto empDto = new EmployeeDto();
		empDto.setEmpId(employee.getEmpId());
		empDto.setFirstName(employee.getFirstName());
		empDto.setLastName(employee.getLastName());
		empDto.setEmailId(employee.getEmailId());
		empDto.setBranch(employee.getBranch());
		return empDto;

	}

	public static Employee mapToEmployee(EmployeeDto empDto) {
		Employee emp = new Employee();
		emp.setEmpId(empDto.getEmpId());
		emp.setFirstName(empDto.getFirstName());
		emp.setLastName(empDto.getLastName());
		emp.setEmailId(empDto.getEmailId());
		emp.setBranch(empDto.getBranch());
		return emp;

	}

	   public static List<EmployeeDto> mapToEmployeeDto(List<Employee> employees) {
	        return employees.stream()
	                .map(UserMapper::mapToEmployeeDto)  // Reuse the single object mapper
	                .collect(Collectors.toList());       // Collect into a List
	    }

}
