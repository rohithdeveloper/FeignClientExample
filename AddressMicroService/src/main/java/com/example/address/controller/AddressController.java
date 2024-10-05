package com.example.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.address.dto.AddressDto;
import com.example.address.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	private AddressService addService;

	@PostMapping("/address")
	public AddressDto addUser(@RequestBody AddressDto addressDto) {
		return addService.createAddress(addressDto);

	}

	@GetMapping("/addresses")
	public List<AddressDto> getAllAddresses() {
		return addService.getAllAddresses();
	}
	
	@GetMapping("/employee/{empId}")
	public List<AddressDto> getAddressByEmployeeId(@PathVariable("empId") Long empId) throws Exception{
		return addService.getAddressByEmployeeId(empId);
	}
	
	@GetMapping("/address/{addressId}")
	public AddressDto getAddressById(@PathVariable("addressId") Long addressId) throws Exception {
		return addService.getAddressById(addressId);
	}

}