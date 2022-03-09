package com.quinbay.march22.dependencyinjection.dto;

public class Department {

    public int id;
    public String name;
    public String professor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Department(){

    }

    public Department(int id, String name, String professor) {
        this.id = id;
        this.name = name;
        this.professor = professor;
    }
}