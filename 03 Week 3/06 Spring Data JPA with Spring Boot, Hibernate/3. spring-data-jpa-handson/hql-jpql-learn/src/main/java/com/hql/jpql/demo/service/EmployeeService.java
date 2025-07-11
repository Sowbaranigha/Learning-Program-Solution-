package com.hql.jpql.demo.service;

import com.hql.jpql.demo.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    List<Employee> getAllPermanentEmployees();

    // ✅ Hands-on 4: Get average salary by department
    double getAverageSalary(int departmentId);

    // ✅ Hands-on 5: Get all employees using native SQL
    List<Employee> getAllEmployeesNative();
}
