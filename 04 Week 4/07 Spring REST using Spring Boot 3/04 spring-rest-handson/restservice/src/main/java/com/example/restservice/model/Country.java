package com.example.restservice.model;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Country model representing a country resource.
 */
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Two-letter country code (e.g., "US", "IN").
     */
    @NotNull(message = "Code cannot be null")
    @Size(min = 2, max = 2, message = "Country code should be exactly 2 characters")
    private String code;

    /**
     * Name of the country.
     */
    @NotNull(message = "Name cannot be null")
    private String name;

    // Default constructor
    public Country() {}

    // Parameterized constructor
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString override for debug logging
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
