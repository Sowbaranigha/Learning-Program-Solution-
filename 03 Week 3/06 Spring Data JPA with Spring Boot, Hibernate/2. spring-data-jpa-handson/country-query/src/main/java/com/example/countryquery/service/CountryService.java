package com.example.countryquery.service;

import com.example.countryquery.model.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void updateCountryName(String code, String newName) {
        Country country = entityManager.find(Country.class, code);
        if (country != null) {
            country.setName(newName);
        } else {
            System.out.println("Country not found for code: " + code);
        }
    }
}
