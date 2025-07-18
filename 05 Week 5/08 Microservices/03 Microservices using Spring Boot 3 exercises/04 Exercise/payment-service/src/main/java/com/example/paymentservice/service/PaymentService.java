package com.example.paymentservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "http://localhost:8084/thirdparty/payment";

    @CircuitBreaker(name = "paymentApi", fallbackMethod = "fallbackPayment")
    public String processPayment() {
        return restTemplate.getForObject(BASE_URL, String.class);
    }

    public String fallbackPayment(Throwable t) {
        System.out.println("⚠️ Fallback triggered due to: " + t.getMessage());
        return "Payment service temporarily unavailable. Please try again later.";
    }
}
