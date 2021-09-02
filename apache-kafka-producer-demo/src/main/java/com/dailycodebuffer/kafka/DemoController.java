package com.dailycodebuffer.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    KafkaTemplate<String,Employee> kafkaTemplate;

    private static final String TOPIC = "t_employee";

    @PostMapping("/register")
    public String publishMessage(@RequestBody Employee employee)
    {
    	System.out.println(employee.getStatus_date());
        kafkaTemplate.send(TOPIC, employee);
        return "Employee registered successfully!";
    }
}
