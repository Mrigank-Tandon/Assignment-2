package com.quinbay.march22.dependencyinjection.service;

import com.quinbay.march22.dependencyinjection.dto.Department;
import com.quinbay.march22.dependencyinjection.repository.DepartmentDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService{




    @Autowired
    DepartmentDb departmentDb;

    @Override
    public List<Department> getAllDepartment(){
        for (Department department : departmentDb.getDepartmenttList()) {
            return departmentDb.getDepartmenttList();
        }
        return null;

    }

    @Override
    public void addDepartment(Department student) {

    }

    @Override
    public Department updateDepartment(Department student) {
        return null;
    }

    @Override
    public void deleteDepartment(int id) {

    }



    @Override
    public Department getDepartment(Integer id) {

        for (Department department : departmentDb.getDepartmenttList()) {
            if (department.getId() == id) {
                return department;
            }


        } return null;
    }







}
