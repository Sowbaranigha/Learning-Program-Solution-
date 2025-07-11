package com.cognizant.ormlearn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        return ResponseEntity.ok(service.getAllCountries());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountry(@PathVariable String code) {
        Optional<Country> country = service.getCountryByCode(code);
        return country.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country created = service.addCountry(country);
        return ResponseEntity.ok(created);
    }

    @PutMapping
    public ResponseEntity<Country> updateCountry(@RequestBody Country country) {
        Optional<Country> existing = service.getCountryByCode(country.getCode());
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Country updated = service.updateCountry(country);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String code) {
        Optional<Country> existing = service.getCountryByCode(code);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteCountry(code);
        return ResponseEntity.noContent().build();
    }
}
