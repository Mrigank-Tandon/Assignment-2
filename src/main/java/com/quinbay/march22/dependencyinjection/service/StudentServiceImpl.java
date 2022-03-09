package com.quinbay.march22.dependencyinjection.service;


import com.quinbay.march22.dependencyinjection.dto.Student;
import com.quinbay.march22.dependencyinjection.entity.StudentEntity;
import com.quinbay.march22.dependencyinjection.entity.StudentEntityMongo;
import com.quinbay.march22.dependencyinjection.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDb studentDb;

    @Autowired
    StudentRepository studentRepository;


    @Autowired
    StudentRedisRepository studentRedisRepository;

    @Autowired
    StudentMongoRepository studentMongoRepository;


//    All the database

    @Override
    public List<Student> getAllStudents() {
        Iterable<StudentEntityMongo> iterable = studentMongoRepository.findAll();
        List<Student> students = new ArrayList<>();
        for (StudentEntityMongo i : iterable) {
            Student s = new Student();
            s.setId(i.getId());
            s.setFname(i.getfName());
            s.setLname(i.getlName());
            s.setBranch(i.getBranch());
            s.setDept_id(i.getDept_id());
            students.add(s);
        }

        Iterable<StudentEntity> iterator = studentRepository.findAll();
        //  List<Student> studentEntities = new ArrayList<>();
        for (StudentEntity i : iterator) {
            Student student = new Student();
            student.setId(i.getId());
            student.setFname(i.getfName());
            student.setLname(i.getlName());
            student.setBranch(i.getBranch());
            student.setDept_id(i.getDept_id());
            students.add(student);

        }
//        students.addAll(studentEntities);
        List<Student> s = studentDb.getStudentList();
        students.addAll(s);
        List<Student> s1 = studentRedisRepository.findAll();
        students.addAll(s1);

        return students;
    }


    @Override
    public void addStudent(Student student, Integer number) {

        if (number == 1) { //Simple db
            studentDb.addStudent(student);
        } else if (number == 2) { //Mongo db
            studentMongoRepository.save(new StudentEntityMongo(student.getId(), student.getFname(), student.getLname(), student.getBranch(), student.getDept_id()));
        } else if (number == 3) { //Redis
            studentRedisRepository.insert(student);
        } else if (number == 4) { //Postgres
            studentRepository.save(new StudentEntity(student.getId(), student.getFname(), student.getLname(), student.getBranch(), student.getDept_id()));
        }
    }

    @Override
    public Student updateStudent(Student student, Integer number) {

        if (number == 1) { //Simple db
            Student s = studentDb.updateStudent(student);
            return s;
        } else if (number == 2) { //Mongo db
            studentMongoRepository.save(new StudentEntityMongo(student.getId(), student.getFname(), student.getLname(), student.getBranch(), student.getDept_id()));
            return null;
        } else if (number == 3) { //Redis
            return studentRedisRepository.save(student);
        } else if (number == 4) { //Postgres
            Iterable<StudentEntity> studentEntityList = studentRepository.findAll();
            for (StudentEntity studentEntity : studentEntityList) {
                if (studentEntity.getId() == student.getId()) {
                    studentRepository.save(new StudentEntity(student.getId(), student.getFname(), student.getLname(), student.getBranch(), student.getDept_id()));
                    return student;
                }
            }
            return null;
        }
        return null;
    }


    @Override
    public void deleteStudent(Long id, Integer number) {
        if (number == 1) { //Simple db
            for (Student student : studentDb.getStudentList()) {
                if (student.getId() == student.getId()) {
                    studentDb.getStudentList().remove(student);
                }
            }
        } else if (number == 2) { //Mongo db
            Iterable<StudentEntityMongo> studentEntityIterator = studentMongoRepository.findAll();
            for (StudentEntityMongo mongoEntity : studentEntityIterator)
                if (mongoEntity.getId() == id) {
                    studentMongoRepository.delete(mongoEntity);
                }
        } else if (number == 3) { //Redis
            studentRedisRepository.delete(id);
        } else if (number == 4) { //Postgres
            studentRepository.deleteById(id);
        }
    }


    //Mongo database


//    @Override
//    public List<Student> getAllStudents(){
//        Iterable<StudentEntityMongo> std = studentMongoRepository.findAll() ;
//        List<Student> std1 = new ArrayList<>();
//        for (StudentEntityMongo item : std) {
//            Student student=new Student(item.getId(),item.getfName(),item.getlName(),item.getBranch(),item.getDept_id());
//            std1.add(student);
//        }
//        return std1;
//    }
//
//
//
//    @Override
//    public void addStudent(Student student) {
//        studentMongoRepository.save(new StudentEntityMongo(student.getId(),student.getFname(),student.getLname(),student.getBranch(),student.getDept_id()));
//    }
//
//    @Override
//    public Student updateStudent(Student student) {
//      studentMongoRepository.save(new StudentEntityMongo(student.getId(), student.getFname(), student.getLname(), student.getBranch(), student.getDept_id()));
//      return null;
//    }
//
//
//    @Override
//    public void deleteStudent(Long id) {
//        Iterable<StudentEntityMongo> studentEntityIterator = studentMongoRepository.findAll();
//        for(StudentEntityMongo mongoEntity:studentEntityIterator)
//            if(mongoEntity.getId()==id) {
//                studentMongoRepository.delete(mongoEntity);
//            }
//
//    }


    //Redis database

//    @Override
//    public List<Student> getAllStudents() {
//        return studentRedisRepository.findAll();
//
//        }
//
//    @Override
//    public void addStudent(Student student) {
//        studentRedisRepository.insert(student);
//    }
//
//    @Override
//    public Student updateStudent(Student student) {
//        return studentRedisRepository.save(student);
//    }
//
//
//    @Override
//    public void deleteStudent(Long id) {
//        studentRedisRepository.delete(id);
//    }

//    postgresql database

//
//    @Override
//    public List<Student> getAllStudents(){
//        Iterable<StudentEntity> studentEntityList  = studentRepository.findAll();
//        List<Student> StudentResponseList = new ArrayList<>();
//        for( StudentEntity studentEntity: studentEntityList){
//            Student student = new Student(studentEntity.getId(), studentEntity.getfName(),studentEntity.getlName(), studentEntity.getBranch(), studentEntity.getDept_id());
//            StudentResponseList.add(student);
//
//
//        }
//        return StudentResponseList;
//    }
//
//    @Override
//    public void addStudent(Student student){
//        studentRepository.save(new StudentEntity(student.getId(),student.getFname(),student.getLname(),student.getBranch(), student.getDept_id() ));
//
//    }
//
//
//
//
//    @Override
//    public Student updateStudent(Student student) {
//        Iterable<StudentEntity> studentEntityList = studentRepository.findAll();
//        for (StudentEntity studentEntity : studentEntityList) {
//            if(studentEntity.getId() == student.getId()) {
//                studentRepository.save(new StudentEntity(student.getId(), student.getFname(), student.getLname(), student.getBranch(), student.getDept_id()));
//                return student;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteStudent(Long id) {
//        studentRepository.deleteById(id);
//
//    }
//
//


//    Simple database

    //    @Override
//    public List<Student> getAllStudents() {
//        for (Student student : studentDb.getStudentList()){
////            for (Department department: departmentDb.getDepartmenttList()){
////                if(student.dept_id == department.id){
////                    return studentDb.getStudentList().addAll(departmentDb.getDepartmenttList());
////
////                }
////            }
// return studentDb.getStudentList();
//        }
//
//return null;
//
//    }


    @Override
    public Student getStudent(Long id, String fName) {

        for (Student student : studentDb.getStudentList()) {
            if (student.getId() == id && student.getFname().equals(fName)) {
                return student;
            }


        }
        return null;
    }


//
//    @Override
//    public void addStudent(Student student) {
//        studentDb.addStudent(student);
//    }


//
//    @Override
//    public Student updateStudent(Student student) {
//        Student s = studentDb.updateStudent(student);
//        return s;
//    }


//    public void deleteStudent(Long id) {
//        for (Student student : studentDb.getStudentList()) {
//            if (student.getId() == student.getId()) {
//                studentDb.getStudentList().remove(student);
//
//            }
//       }
//    }


}






