package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.dto.EmployeeSummaryDTO;
import com.example.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // 🔹 Derived query methods
    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByNameContaining(String keyword);

    // 🔹 Custom JPQL query by email
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmail(@Param("email") String email);

    // 🔹 Custom JPQL query with multiple parameters
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name% AND e.department.id = :deptId")
    List<Employee> searchByNameAndDepartment(@Param("name") String name, @Param("deptId") Long deptId);

    // 🔹 Interface-based projection (returns only name and email)
    List<EmployeeNameEmailProjection> findAllBy();

    // 🔹 Class-based projection using constructor expression (DTO)
    @Query("SELECT new com.example.EmployeeManagementSystem.dto.EmployeeSummaryDTO(e.name, e.department.name) FROM Employee e")
    List<EmployeeSummaryDTO> findEmployeeSummaries();
}
