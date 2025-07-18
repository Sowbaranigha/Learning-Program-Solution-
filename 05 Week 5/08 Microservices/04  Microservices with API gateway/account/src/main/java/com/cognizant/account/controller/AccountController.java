package com.cognizant.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/{number}")
    public Map<String, Object> getAccount(@PathVariable String number) {
        logger.info("Fetching account details for account number: {}", number);

        Map<String, Object> response = new HashMap<>();
        response.put("number", number);
        response.put("type", "savings");
        response.put("balance", 234343);

        logger.info("Response: {}", response);

        return response;
    }
}
