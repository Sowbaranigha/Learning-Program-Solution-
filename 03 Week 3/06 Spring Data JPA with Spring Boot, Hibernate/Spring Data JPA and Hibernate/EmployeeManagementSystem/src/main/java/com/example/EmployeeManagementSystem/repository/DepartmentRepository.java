package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // 🔹 Derived query method
    Department findByName(String name);

    // 🔹 Custom query using @Query
    @Query("SELECT d FROM Department d WHERE d.name LIKE %?1%")
    List<Department> searchByName(String keyword);
}
