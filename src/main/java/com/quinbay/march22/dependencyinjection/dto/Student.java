package com.quinbay.march22.dependencyinjection.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Student implements Serializable {

    @NotNull @Id
    public Long id;

    @NotBlank(message = "This cannot be empty")
    public String fname;

    public String lname;
    public String branch;
    public Integer dept_id;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    public Student(){

    }

    public Student(Long id, String fname, String lname, String branch, int dept_id) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.branch = branch;
        this.dept_id = dept_id;
    }
}