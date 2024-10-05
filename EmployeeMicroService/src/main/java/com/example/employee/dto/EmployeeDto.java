package com.example.employee.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private long empId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String branch;

//	private List<Address> addresses=new ArrayList<>();
	private List<AddressDto> addresses=new ArrayList<>();

}