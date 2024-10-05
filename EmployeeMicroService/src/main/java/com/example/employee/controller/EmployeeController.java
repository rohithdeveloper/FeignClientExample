package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/employees")
	public EmployeeDto addUser(@RequestBody EmployeeDto empDto) {
		return empService.createEmployee(empDto);

	}

	@GetMapping("employees/{id}")
	public EmployeeDto getUserById(@PathVariable("id") long empId) throws Exception {
		return empService.getEmployeeById(empId);
	}
	
	@GetMapping("allEmployes")
	public List<EmployeeDto> getAllEmployees(){
		return empService.getAllEmployees();
	}
}
