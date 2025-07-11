package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.entity.Department;
import com.example.EmployeeManagementSystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // 1. Get all departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // 2. Add new department
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
}
