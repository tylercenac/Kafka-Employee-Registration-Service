package com.dailycodebuffer.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.dailycodebuffer.kafka.repository")
@ComponentScan("com.dailycodebuffer.*")
public class ApacheKafkaConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApacheKafkaConsumerDemoApplication.class, args);
	}

}
