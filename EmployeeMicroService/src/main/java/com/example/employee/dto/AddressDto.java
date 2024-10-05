package com.example.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

	private Long addressId;
	private String landMark;
	private String state;
	private String district;
	private String zip;
	private Long empId;
	
}
