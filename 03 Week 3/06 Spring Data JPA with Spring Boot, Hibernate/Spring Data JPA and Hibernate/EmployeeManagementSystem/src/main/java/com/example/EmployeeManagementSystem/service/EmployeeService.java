package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // ✅ Get all employees
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    // ✅ Get employee by ID
    public Employee getEmployeeById(Long id) {
        logger.info("Fetching employee by ID: {}", id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("❌ Employee not found with ID: " + id));
    }

    // ✅ Save a new employee
    public Employee saveEmployee(Employee employee) {
        logger.info("Saving new employee: {}", employee.getName());
        return employeeRepository.save(employee);
    }

    // ✅ Batch save for performance (Hibernate batch insert)
    @Transactional
    public List<Employee> saveAllEmployees(List<Employee> employees) {
        logger.info("Batch saving {} employees", employees.size());
        return employeeRepository.saveAll(employees);
    }

    // ✅ Update an existing employee
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        logger.info("Updating employee with ID: {}", id);
        Employee existingEmployee = getEmployeeById(id);

        existingEmployee.setName(employeeDetails.getName());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setDepartment(employeeDetails.getDepartment());

        return employeeRepository.save(existingEmployee);
    }

    // ✅ Delete employee by ID
    public void deleteEmployee(Long id) {
        logger.info("Deleting employee with ID: {}", id);
        if (!employeeRepository.existsById(id)) {
            throw new IllegalArgumentException("❌ Cannot delete. Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id);
    }

    // 🟦 You can add pagination, sorting, filtering, or projections here later
}
