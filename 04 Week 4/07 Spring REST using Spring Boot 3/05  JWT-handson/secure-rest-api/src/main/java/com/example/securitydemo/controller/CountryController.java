package com.example.securitydemo.controller;

import com.example.securitydemo.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @GetMapping("/countries")
    public List<Country> getCountries() {
        LOGGER.info("Fetching list of countries");
        return List.of(
                new Country("US", "United States"),
                new Country("DE", "Germany"),
                new Country("IN", "India"),
                new Country("JP", "Japan")
        );
    }
}
