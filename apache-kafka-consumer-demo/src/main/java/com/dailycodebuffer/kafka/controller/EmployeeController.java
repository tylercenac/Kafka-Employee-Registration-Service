package com.dailycodebuffer.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.kafka.entity.Employee;
import com.dailycodebuffer.kafka.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/getByStatus/{status}")
	public List<Employee> getEmployeesByStatus(@PathVariable String status) {
		return employeeService.getEmployeesByStatus(status);
	}
	
	
}
