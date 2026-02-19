package com.example.address.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
	
	private static final Logger logger=LoggerFactory.getLogger(AddressServiceImpl.class);

	@Override
	public AddressDto createAddress(AddressDto addressDto) {
		// TODO Auto-generated method stub
		Address address = UserMapper.mapToAddress(addressDto);
		Address savedAddress = addRepo.save(address);

		AddressDto addDto = UserMapper.mapToAddressDto(savedAddress);
		logger.info("address is added with id -{}",addDto.getAddressId());
		return addDto;
	}

	@Override
	@Cacheable(cacheNames="Address",key="#id")
	public AddressDto getAddressById(Long id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Address> address = addRepo.findById(id);
		if (address.isPresent()) {
			// Map Employee to EmployeeDto
			AddressDto addressDto = UserMapper.mapToAddressDto(address.get());
			logger.info("fetch address from DB");
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
			logger.info("fetch all address with empId from DB");
			return addressDto;
		} else {
			// Throw exception if employee is not found
			throw new Exception("address id not found");
		}

	}

	// for update with id use " @CachePut(cacheNames="Address",key="#id") "
	// for delete with id use " @CacheEvict(cacheNames="Address",key="#id") "

}
