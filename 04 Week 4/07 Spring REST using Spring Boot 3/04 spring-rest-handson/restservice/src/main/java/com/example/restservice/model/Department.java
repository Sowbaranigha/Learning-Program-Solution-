package com.example.restservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Department {

    @NotNull(message = "Department ID cannot be null")
    private Integer id;

    @NotBlank(message = "Department name cannot be blank")
    @Size(min = 1, max = 30, message = "Department name must be 1 to 30 characters")
    private String name;

    // Default constructor
    public Department() {}

    // Parameterized constructor
    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Optional: toString() method for debugging
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
