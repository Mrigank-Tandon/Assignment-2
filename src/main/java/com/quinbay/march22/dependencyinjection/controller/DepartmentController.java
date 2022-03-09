package com.quinbay.march22.dependencyinjection.controller;

import com.quinbay.march22.dependencyinjection.dto.Department;
import com.quinbay.march22.dependencyinjection.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getDepartment(){
        return departmentService.getAllDepartment();
    }
}





