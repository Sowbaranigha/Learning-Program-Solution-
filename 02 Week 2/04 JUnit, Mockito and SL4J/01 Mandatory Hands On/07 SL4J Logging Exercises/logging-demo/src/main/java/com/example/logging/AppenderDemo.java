package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderDemo {
    private static final Logger logger = LoggerFactory.getLogger(AppenderDemo.class);

    public static void main(String[] args) {
        logger.debug("This is a DEBUG log");
        logger.info("This is an INFO log");
        logger.warn("This is a WARN log");
        logger.error("This is an ERROR log");
    }
}
