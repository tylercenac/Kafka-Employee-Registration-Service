package com.dailycodebuffer.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.dailycodebuffer.kafka.entity.Employee;
import com.dailycodebuffer.kafka.service.EmployeeService;

@Component
public class KafkaConsumer {
	
	@Autowired
	EmployeeService employeeService;

    @KafkaListener(topics = "t_employee", groupId = "group_id")
    public void consume(String employee)
    {
    	Employee emp = convertEmployeeStringToEmployeeObject(employee);	
        employeeService.registerEmployee(emp);
    }
    
    
    public Employee convertEmployeeStringToEmployeeObject(String employeeString) {
    	
    	String[] properties = employeeString.split(",");
    	String[] params = new String[5];
    	
    	for(int i = 0; i<properties.length; i++) {
    		
    		String value = properties[i].split(":")[1];
    		int start = 1;
    	    int end = value.length()-1;
    	    
    	    params[i] = value.substring(start, end);
    	    
    	}
 
    	
    	Employee employee = new Employee(params[0], params[1], params[2], params[3], params[4]);
    	
    	return employee;
    }
}
