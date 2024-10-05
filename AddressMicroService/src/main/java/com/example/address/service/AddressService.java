package com.example.address.service;

import java.util.List;

import com.example.address.dto.AddressDto;

public interface AddressService {

	AddressDto createAddress(AddressDto addressDto);

	AddressDto getAddressById(Long addressId) throws Exception;

	List<AddressDto> getAllAddresses();

	List<AddressDto> getAddressByEmployeeId(Long empId) throws Exception;

}
