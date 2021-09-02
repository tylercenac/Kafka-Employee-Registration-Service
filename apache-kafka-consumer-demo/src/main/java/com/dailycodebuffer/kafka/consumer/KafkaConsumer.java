package com.dailycodebuffer.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "t_employee", groupId = "group_id")
    public void consume(String employee)
    {
        System.out.println("employee = " + employee);
    }
}
