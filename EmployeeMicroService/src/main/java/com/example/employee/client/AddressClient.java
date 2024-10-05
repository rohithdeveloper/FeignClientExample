package com.example.employee.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employee.dto.AddressDto;



@FeignClient(name = "ADDRESS-MICROSERVICE",url = "http://localhost:8081/api")
public interface AddressClient {

	@GetMapping("/employee/{empId}")
	public List<AddressDto> getAddressByEmployeeId(@PathVariable("empId") Long empId);
}
