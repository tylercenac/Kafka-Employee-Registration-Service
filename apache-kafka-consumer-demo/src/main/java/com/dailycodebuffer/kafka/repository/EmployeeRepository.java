package com.dailycodebuffer.kafka.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.dailycodebuffer.kafka.entity.Employee;

import java.util.List;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
	List<Employee> findByStatus(String status);
	List<Employee> findByEmail(String email);
}

