package com.ust.Employee_JpaStreamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ust.Employee_JpaStreamer", "com.speedment.jpastreamer"})
public class EmployeeJpaStreamerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeJpaStreamerApplication.class, args);
	}

}
