package com.example.jwt.main;

import com.example.jwt.config.JwtConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtConfig.class)
public class JwtDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
    }
}
