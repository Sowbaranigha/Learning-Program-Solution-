package com.example.restservice.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the RESTful Web Service application.
 */
@SpringBootApplication
public class RestServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
        LOGGER.info("RestServiceApplication has started successfully.");
    }
}

