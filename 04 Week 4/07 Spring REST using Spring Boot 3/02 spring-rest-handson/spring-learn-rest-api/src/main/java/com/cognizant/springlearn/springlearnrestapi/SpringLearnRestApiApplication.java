package com.cognizant.springlearn.springlearnrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

// Loads the bean definitions from country.xml in classpath
@ImportResource("classpath:country.xml")
@SpringBootApplication
public class SpringLearnRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnRestApiApplication.class, args);
    }
}
