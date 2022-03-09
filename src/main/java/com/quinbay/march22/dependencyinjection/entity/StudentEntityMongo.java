package com.quinbay.march22.dependencyinjection.entity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import javax.validation.constraints.NotBlank;


@Document(collection = "Student")
public class StudentEntityMongo {
    @MongoId
    private Long id;
    @NotBlank(message = "Name cannot be empty")
    private String fName;
    private String lName;
    private String branch;
    private int dept_id;
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

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getBranch() {
        return branch;
    }


    public void setBranch(String branch) {
        this.branch = branch;
    }

    public StudentEntityMongo(Long id, @NotBlank(message = "Name cannot be empty") String fName, String lName, String branch, int dept_id) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.branch = branch;
        this.dept_id = dept_id;
    }
}