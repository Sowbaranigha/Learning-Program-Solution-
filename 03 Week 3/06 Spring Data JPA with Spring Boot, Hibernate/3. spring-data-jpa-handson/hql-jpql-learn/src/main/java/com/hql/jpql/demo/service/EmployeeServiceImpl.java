package com.hql.jpql.demo.service;

import com.hql.jpql.demo.model.Employee;
import com.hql.jpql.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    // ✅ Hands-on 4: Get average salary by department
    @Override
    public double getAverageSalary(int departmentId) {
        return employeeRepository.getAverageSalary(departmentId);
    }

    // ✅ Hands-on 5: Get all employees using native SQL
    @Override
    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }
}
