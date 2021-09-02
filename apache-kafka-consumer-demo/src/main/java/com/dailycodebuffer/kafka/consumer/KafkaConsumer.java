package com.dailycodebuffer.kafka.consumer;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        employeeService.saveEmployee(emp);
        
        if(emp.getStatus().equals("PENDING")) {
        	System.out.println("Employee registration saved!");
        } else if(emp.getStatus().equals("APPROVED")) {
        	System.out.println("Employee approval saved!");
        } else {
        	System.out.println("Invalid employee status");
        }
        
    }
    
    
    public Employee convertEmployeeStringToEmployeeObject(String employeeString) {
    	
    	String[] properties = employeeString.split(",");
    	String[] params = new String[5];
    	
    	for(int i = 0; i<properties.length; i++) {
    		
			String key = properties[i].split(":")[0];
    		String value = properties[i].split(":")[1];
			
    		int start = 1;
    	    int end = value.length()-1;
			if(key.substring(1, key.length()-1).equals("status_date")){
				end = value.length()-2;
			}
			
    	    
    	    params[i] = value.substring(start, end);
    	    
    	}
 
    	
    	Employee employee = new Employee(params[0], params[1], params[2], params[3], params[4]);
    	
    	return employee;
    }
}
