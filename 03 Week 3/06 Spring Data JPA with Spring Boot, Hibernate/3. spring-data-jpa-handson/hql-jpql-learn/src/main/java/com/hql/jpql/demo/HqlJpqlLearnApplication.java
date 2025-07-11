package com.hql.jpql.demo;

import com.hql.jpql.demo.model.Employee;
import com.hql.jpql.demo.model.Skill;
import com.hql.jpql.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HqlJpqlLearnApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(HqlJpqlLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        testGetAllPermanentEmployees();
        testGetAverageSalaryByDepartment(1); // Change department ID if needed
        testGetAllEmployeesNative();         // ✅ Hands-on 5
    }

    private void testGetAllPermanentEmployees() {
        System.out.println("=== Permanent Employees ===");
        List<Employee> employees = employeeService.getAllPermanentEmployees();

        for (Employee emp : employees) {
            String deptName = emp.getDepartment() != null ? emp.getDepartment().getName() : "N/A";
            System.out.println(emp.getId() + " - " + emp.getName() + " - " + emp.getSalary() + " - " + deptName);

            List<Skill> skills = emp.getSkillList();
            if (skills != null && !skills.isEmpty()) {
                System.out.println("Skills:");
                skills.forEach(skill -> System.out.println("  - " + skill.getName()));
            } else {
                System.out.println("No Skills Assigned.");
            }

            System.out.println();
        }
    }

    private void testGetAverageSalaryByDepartment(int deptId) {
        System.out.println("=== Average Salary for Department ID: " + deptId + " ===");
        double avgSalary = employeeService.getAverageSalary(deptId);
        System.out.println("Average Salary: " + avgSalary);
        System.out.println();
    }

    // ✅ Hands-on 5: Native Query - Get All Employees
    private void testGetAllEmployeesNative() {
        System.out.println("=== All Employees (Native Query) ===");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        for (Employee emp : employees) {
            System.out.println(emp.getId() + " - " + emp.getName() + " - " + emp.getSalary());
        }
        System.out.println();
    }
}
