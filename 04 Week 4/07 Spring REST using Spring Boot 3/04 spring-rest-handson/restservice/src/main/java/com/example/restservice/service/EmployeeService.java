package com.example.restservice.service;

import com.example.restservice.dao.EmployeeDao;
import com.example.restservice.exception.EmployeeNotFoundException;
import com.example.restservice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao dao;

    // ✅ Update existing employee
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        dao.updateEmployee(employee);
    }

    // ✅ Delete employee by ID
    public void deleteEmployeeById(int id) throws EmployeeNotFoundException {
        dao.deleteEmployeeById(id);
    }
}
