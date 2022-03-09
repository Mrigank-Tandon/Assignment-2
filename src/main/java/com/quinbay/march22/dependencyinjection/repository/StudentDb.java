package com.quinbay.march22.dependencyinjection.repository;

import com.quinbay.march22.dependencyinjection.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDb {
    List<Student> llist=new ArrayList<>();

    {
        Student obj1 = new Student(1L,"bhumi1","jain1","cse1",1);
        Student obj2 = new Student(2L,"bhumi2","jain2","cse2",2);
        Student obj3 = new Student(3L,"bhumi3","jain3","cse3",1);
        Student obj4 = new Student(4L,"bhumi4","jain4","cse4",3);
        Student obj5 = new Student(5L,"bhumi5","jain5","cse5",3);
        llist.add(obj1);
        llist.add(obj2);
        llist.add(obj3);
        llist.add(obj4);
        llist.add(obj5);
    }

    public List<Student> getStudentList(){


        return llist;
    }
    public void addStudent(Student student){
        llist.add(student);
    }

    public void deleteStudent(Long id){

        for(Student i : llist){
            if(i.getId() == id){
                llist.remove(i);
                break;
            }
        }
        }

    public Student updateStudent(Student student){
        for(Student i : llist){
            if(i.getId() == student.getId()){
                i.setFname(student.getFname());
                i.setLname(student.getLname());
                i.setBranch(student.getBranch());
              //  i.getDept_id(student.getDept_id());
                return new Student(i.getId(), i.getFname(), i.getLname(), i.getBranch(), i.getDept_id());
            }
        }
        return null;
    }



}