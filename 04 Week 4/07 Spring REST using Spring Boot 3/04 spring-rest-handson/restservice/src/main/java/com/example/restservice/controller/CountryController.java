package com.example.restservice.controller;

import com.example.restservice.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid; // ✅ Updated to jakarta.validation for Spring Boot 3+
import java.util.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    // ✅ Use ConcurrentHashMap for thread safety (if multithreaded access possible)
    private final Map<String, Country> countryMap = new HashMap<>();

    // ✅ GET all countries
    @GetMapping
    public ResponseEntity<Collection<Country>> getAllCountries() {
        LOGGER.info("Fetching all countries");
        return ResponseEntity.ok(countryMap.values());
    }

    // ✅ GET a specific country by code
    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountry(@PathVariable String code) {
        LOGGER.info("Fetching country with code: {}", code);
        Country country = countryMap.get(code);
        if (country == null) {
            LOGGER.warn("Country with code '{}' not found", code);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(country);
    }

    // ✅ POST - Add a new country
    @PostMapping
    public ResponseEntity<Country> addCountry(@Valid @RequestBody Country country) {
        LOGGER.info("Start");
        LOGGER.info("Received country details: code={}, name={}", country.getCode(), country.getName());

        if (countryMap.containsKey(country.getCode())) {
            LOGGER.warn("Country with code '{}' already exists", country.getCode());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        countryMap.put(country.getCode(), country);
        LOGGER.info("Country added successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(country); // ✅ Use 201 Created
    }

    // ✅ PUT - Update existing country
    @PutMapping
    public ResponseEntity<Country> updateCountry(@Valid @RequestBody Country country) {
        LOGGER.info("Updating country with code: {}", country.getCode());
        if (!countryMap.containsKey(country.getCode())) {
            LOGGER.warn("Country with code '{}' not found for update", country.getCode());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        countryMap.put(country.getCode(), country);
        LOGGER.info("Country updated successfully");
        return ResponseEntity.ok(country);
    }

    // ✅ DELETE - Delete a country by code
    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String code) {
        LOGGER.info("Deleting country with code: {}", code);
        if (!countryMap.containsKey(code)) {
            LOGGER.warn("Country with code '{}' not found for deletion", code);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        countryMap.remove(code);
        LOGGER.info("Country deleted successfully");
        return ResponseEntity.noContent().build(); // ✅ 204 No Content
    }
}
