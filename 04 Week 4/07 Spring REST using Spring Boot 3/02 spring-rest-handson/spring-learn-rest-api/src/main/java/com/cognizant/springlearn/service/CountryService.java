package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CountryService {

    private static final Map<String, Country> COUNTRY_MAP = new HashMap<>();

    static {
        COUNTRY_MAP.put("IN", new Country("IN", "India"));
        COUNTRY_MAP.put("US", new Country("US", "United States"));
    }

    public Country findCountryByCode(String code) {
        return COUNTRY_MAP.get(code.toUpperCase());
    }
}
