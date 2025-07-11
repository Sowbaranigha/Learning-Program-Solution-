package com.quiz.quizapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.quiz")
@EnableJpaRepositories(basePackages = "com.quiz.repository")
@EntityScan(basePackages = "com.quiz.model")  // ✅ Tells Spring where to find @Entity classes
public class QuizApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }
}