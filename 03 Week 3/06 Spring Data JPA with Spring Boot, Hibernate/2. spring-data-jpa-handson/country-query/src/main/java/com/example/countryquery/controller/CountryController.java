package com.example.countryquery.controller;

import com.example.countryquery.model.Country;
import com.example.countryquery.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    // Get all countries
    @GetMapping
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Get country by code
    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return countryRepository.findById(code).orElse(null);
    }
}
