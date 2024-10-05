package com.example.address.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.address.dto.AddressDto;
import com.example.address.model.Address;

public class UserMapper {
	
	public static AddressDto mapToAddressDto(Address address) {
		AddressDto addDto=new AddressDto();
		addDto.setAddressId(address.getAddressId());
		addDto.setLandMark(address.getLandMark());
		addDto.setDistrict(address.getDistrict());
		addDto.setState(address.getState());
		addDto.setZip(address.getZip());
		addDto.setEmpId(address.getEmpId());
		return addDto;
	}
	
	public static Address mapToAddress(AddressDto addressDto) {
		Address address=new Address();
		address.setAddressId(addressDto.getAddressId());
		address.setLandMark(addressDto.getLandMark());
		address.setDistrict(addressDto.getDistrict());
		address.setState(addressDto.getState());
		address.setZip(addressDto.getZip());
		address.setEmpId(addressDto.getEmpId());
		return address;
		
		
	}

	public static List<AddressDto> mapToAddressDto(List<Address> employees) {
		// TODO Auto-generated method stub
		return employees.stream()
                .map(UserMapper::mapToAddressDto)  // Reuse the single object mapper
                .collect(Collectors.toList());      
	}
}