package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String name = "Sowba";
        int age   = 22;

        logger.info("User {} is {} years old", name, age);

        try {
            /* ---------- deliberately trigger an ArithmeticException ---------- */
            int denominator = 0;        // not a compile time constant
            int result      = 10 / denominator;
            logger.debug("Result = {}", result);   // never reached
        } catch (ArithmeticException e) {
            logger.error("An error occurred for user {}", name, e);
        }
    }
}
