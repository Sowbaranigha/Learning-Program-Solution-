package com.example.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.Employee;

public class EmployeeDao {

    // Static employee list initialized once
    private static final List<Employee> EMPLOYEE_LIST;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (List<Employee>) context.getBean("employeeList");

        if (EMPLOYEE_LIST == null || EMPLOYEE_LIST.isEmpty()) {
            throw new RuntimeException("Employee list could not be loaded from XML configuration.");
        }
    }

    // Constructor not needed unless you want additional logic
    public EmployeeDao() {
        // You can add logging or debug info here if required
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
