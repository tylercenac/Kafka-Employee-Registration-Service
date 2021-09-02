package com.dailycodebuffer.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.kafka.entity.Employee;
import com.dailycodebuffer.kafka.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee registerEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	
	
	
	
}
