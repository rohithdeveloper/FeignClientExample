package com.example.employee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long addressId;

	@Column(name = "lane1")
	private String landMark;

	@Column(name = "state")
	private String state;

	@Column(name = "district")
	private String district;

	@Column(name = "pincode")
	private String zip;
	
	@Column(name = "empId")
	private Long empId;
	
	
}