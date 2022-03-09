package com.quinbay.march22.dependencyinjection.service;

import com.quinbay.march22.dependencyinjection.dto.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartment();
    Department getDepartment(Integer id);
    void addDepartment(Department student);
    Department updateDepartment(Department student);
    void deleteDepartment(int id);
}
