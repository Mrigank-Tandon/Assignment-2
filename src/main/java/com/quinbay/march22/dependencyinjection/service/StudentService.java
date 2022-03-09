package com.quinbay.march22.dependencyinjection.service;

import com.quinbay.march22.dependencyinjection.dto.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudent(Long id, String fName);
    void addStudent(Student student, Integer number);
    Student updateStudent(Student student, Integer number);
    void deleteStudent(Long id, Integer number);
}


