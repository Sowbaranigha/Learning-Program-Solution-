package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class EmployeeRestApp {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeRestApp.class);

    public static void main(String[] args) {
        SpringApplication.run(EmployeeRestApp.class, args);
        logger.info("EmployeeRestApp has started successfully.");
    }
}
