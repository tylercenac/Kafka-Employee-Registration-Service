package com.dailycodebuffer.kafka;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    KafkaTemplate<String,Employee> kafkaTemplate;
    
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate2;

    private static final String TOPIC = "t_employee";

    @PostMapping("/register")
    public String registerEmployee(@RequestBody Employee employee)
    {
    	System.out.println("Registering employee...");
        kafkaTemplate.send(TOPIC, employee);
        return "Employee registered successfully!";
    }
    
    @PostMapping("/approve/{email}")
    public String approveEmployee(@PathVariable String email)
    {
    	
    	String message = ("APPROVING:" + email);
        kafkaTemplate2.send(TOPIC, message);
        return "Employee approved!";
    }
    
    @PostMapping("/decline/{email}")
    public String declineEmployee(@PathVariable String email)
    {
    	
    	String message = ("DECLINING:" + email);
        kafkaTemplate2.send(TOPIC, message);
        return "Employee approved!";
    }
}
