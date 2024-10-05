package com.example.address.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.address.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	Optional<List<Address>> findByEmpId(Long empId);
}
