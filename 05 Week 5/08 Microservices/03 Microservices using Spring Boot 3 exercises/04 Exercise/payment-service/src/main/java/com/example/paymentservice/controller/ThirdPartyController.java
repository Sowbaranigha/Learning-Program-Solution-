package com.example.paymentservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/thirdparty")
public class ThirdPartyController {

    private static final Logger logger = LoggerFactory.getLogger(ThirdPartyController.class);

    @GetMapping("/payment")
    public String slowApi() {
        logger.info("Calling third-party payment API...");

        try {
            // Simulate a 5-second delay to mimic a slow external service
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("Thread interrupted during simulated delay", e);
            Thread.currentThread().interrupt(); // restore interrupt status
            return "Error: Interrupted during payment processing.";
        }

        logger.info("Third-party payment processed successfully.");
        return "Payment Processed";
    }
}
