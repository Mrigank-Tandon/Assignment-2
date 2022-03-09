package com.quinbay.march22.dependencyinjection.repository;

import com.quinbay.march22.dependencyinjection.dto.Department;
import com.quinbay.march22.dependencyinjection.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDb {
    List<Department> llist = new ArrayList<>();

    {
        Department obj1 = new Department(1, "CSE", "Ammy");
        Department obj2 = new Department(2, "ECE", "Emma");
        Department obj3 = new Department(3, "IT", "Laura");
        Department obj4 = new Department(4, "Mechanical", "Lexi");
        Department obj5 = new Department(5, "EE", "Mona");
        llist.add(obj1);
        llist.add(obj2);
        llist.add(obj3);
        llist.add(obj4);
        llist.add(obj5);
    }

    public List<Department> getDepartmenttList() {


        return llist;
    }




}