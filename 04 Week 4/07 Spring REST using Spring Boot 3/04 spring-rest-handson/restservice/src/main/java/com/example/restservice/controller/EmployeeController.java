package com.example.restservice.controller;

import com.example.restservice.exception.EmployeeNotFoundException;
import com.example.restservice.model.Employee;
import com.example.restservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService service;

    // ✅ PUT endpoint to update an employee
    @PutMapping
    public ResponseEntity<String> updateEmployee(@Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("Start updating employee: {}", employee);

        service.updateEmployee(employee);

        LOGGER.info("Employee updated successfully");
        return ResponseEntity.ok("Employee updated successfully");
    }

    // ✅ DELETE endpoint to remove employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        LOGGER.info("Start deleting employee with ID: {}", id);

        service.deleteEmployeeById(id);

        LOGGER.info("Employee with ID {} deleted successfully", id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
