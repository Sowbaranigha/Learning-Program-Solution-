package com.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.dao.DepartmentDao;

@Service
public class DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentService() {
        this.departmentDao = new DepartmentDao();
    }

    public List<String> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
