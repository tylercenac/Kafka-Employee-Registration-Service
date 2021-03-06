package com.dailycodebuffer.kafka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.kafka.entity.Employee;
import com.dailycodebuffer.kafka.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public List<Employee> getEmployeesByStatus(String status) {
		return employeeRepository.findByStatus(status);
	}
	
	public Employee getEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}
	
	public String declineEmployee(String id) {
		employeeRepository.deleteById(id);
		return "Employee with email= " + id + " has been deleted if existing";
	}
	
}
