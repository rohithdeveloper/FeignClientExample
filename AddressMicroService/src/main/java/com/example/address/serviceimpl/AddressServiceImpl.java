package com.example.address.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.address.dto.AddressDto;
import com.example.address.model.Address;
import com.example.address.modelmapper.UserMapper;
import com.example.address.repository.AddressRepository;
import com.example.address.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addRepo;

	@Override
	public AddressDto createAddress(AddressDto addressDto) {
		// TODO Auto-generated method stub
		Address address = UserMapper.mapToAddress(addressDto);
		Address savedAddress = addRepo.save(address);

		AddressDto addDto = UserMapper.mapToAddressDto(savedAddress);
		return addDto;
	}

	@Override
	public AddressDto getAddressById(Long id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Address> address = addRepo.findById(id);
		if (address.isPresent()) {
			// Map Employee to EmployeeDto
			AddressDto addressDto = UserMapper.mapToAddressDto(address.get());
			return addressDto;
		} else {
			// Throw exception if employee is not found
			throw new Exception("address id not found");
		}
	}

	@Override
	public List<AddressDto> getAllAddresses() {
		// TODO Auto-generated method stub
		List<Address> addresses = addRepo.findAll();
		List<AddressDto> employeesDto = UserMapper.mapToAddressDto(addresses);
		return employeesDto;
	}

	@Override
	public List<AddressDto> getAddressByEmployeeId(Long empId) throws Exception {
		// TODO Auto-generated method stub
		Optional<List<Address>> address = addRepo.findByEmpId(empId);
		if (address.isPresent()) {
			// Map Employee to EmployeeDto
			List<AddressDto> addressDto = UserMapper.mapToAddressDto(address.get());
			return addressDto;
		} else {
			// Throw exception if employee is not found
			throw new Exception("address id not found");
		}

	}

}
