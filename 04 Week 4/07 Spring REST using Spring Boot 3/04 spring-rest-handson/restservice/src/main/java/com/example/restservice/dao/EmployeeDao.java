package com.example.restservice.dao;

import com.example.restservice.exception.EmployeeNotFoundException;
import com.example.restservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    // In-memory map to simulate database
    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    // ✅ Add a new employee
    public void addEmployee(Employee employee) {
        if (employee == null || employee.getId() == null) {
            throw new IllegalArgumentException("Employee or Employee ID must not be null");
        }
        employeeMap.put(employee.getId(), employee);
    }

    // ✅ Get all employees
    public Collection<Employee> getAllEmployees() {
        return employeeMap.values();
    }

    // ✅ Update employee if exists
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        if (employee == null || employee.getId() == null) {
            throw new IllegalArgumentException("Employee or Employee ID must not be null");
        }

        Integer id = employee.getId();
        if (!employeeMap.containsKey(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }

        employeeMap.put(id, employee);
    }

    // ✅ Delete employee by ID
    public void deleteEmployeeById(int id) throws EmployeeNotFoundException {
        if (!employeeMap.containsKey(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        employeeMap.remove(id);
    }

    // (Optional) Get single employee by ID
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
        Employee employee = employeeMap.get(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        return employee;
    }
}
