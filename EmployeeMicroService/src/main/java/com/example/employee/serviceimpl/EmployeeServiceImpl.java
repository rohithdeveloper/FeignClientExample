package com.example.employee.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.employee.client.AddressClient;
import com.example.employee.dto.AddressDto;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.model.Employee;
import com.example.employee.modelmapper.UserMapper;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

   @Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private AddressClient addressClient;

	private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = UserMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = empRepo.save(employee);
		logger.info("employee is added ");
		return UserMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = empRepo.findAll();
		List<EmployeeDto> employeesDto = UserMapper.mapToEmployeeDto(employees);
		logger.info("fetch all employees from DB");
		return employeesDto;
	}
	
	
	
	@Override
	public List<EmployeeDto> getAllEmployeesWithAddresses() {

	    List<Employee> employees = empRepo.findAll();

	    List<EmployeeDto> employeeDtoList = new ArrayList<>();

	    for (Employee emp : employees) {

	        // Mapping Employee to EmployeeDto
	        EmployeeDto empDto = UserMapper.mapToEmployeeDto(emp);

	        // Fetch addresses using Feign
	        List<AddressDto> addresses =
	                addressClient.getAddressByEmployeeId(empDto.getEmpId());

	        // Set addresses to DTO
	        empDto.setAddresses(addresses);

	        // Add to final list
	        employeeDtoList.add(empDto);
	        logger.info("all employees with addresses");
	    }

	    return employeeDtoList;
	}


	// Feign Client

	@Override
	@Cacheable(cacheNames="Employee",key="#id")
	public EmployeeDto getEmployeeById(long id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Employee> employee = empRepo.findById(id);
		if (employee.isPresent()) {
			EmployeeDto empDto = UserMapper.mapToEmployeeDto(employee.get());
			// http://localhost:8081/api/employee/252
			List<AddressDto> forObject = addressClient.getAddressByEmployeeId(empDto.getEmpId());
			logger.info("{}", forObject);
			empDto.setAddresses(forObject);
			logger.info("fetch employee from DB");
			return empDto;
		} else {
			throw new Exception("Employee not found");
		}
	}

	
	
	
}





