package com.hql.jpql.demo.repository;

import com.hql.jpql.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // ✅ Hands-on 3: Get all permanent employees (HQL with JOIN FETCH)
    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.department d LEFT JOIN FETCH e.skillList WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // ✅ Hands-on 4: Get average salary by department (HQL)
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    double getAverageSalary(@Param("id") int departmentId);

    // ✅ Hands-on 5: Get all employees using native SQL query
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
