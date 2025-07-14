package com.example.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SuppressWarnings("unchecked")
public class DepartmentDao {

    private static List<String> DEPARTMENT_LIST;

    static {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml")) {
            DEPARTMENT_LIST = (List<String>) context.getBean("departmentList");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load department list from Spring context", e);
        }
    }

    public List<String> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
