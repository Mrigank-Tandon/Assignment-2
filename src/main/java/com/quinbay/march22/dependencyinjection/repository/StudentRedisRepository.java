package com.quinbay.march22.dependencyinjection.repository;

import com.quinbay.march22.dependencyinjection.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRedisRepository {

    private String STUDENT_COLLECTION = "STUDENT";
    private RedisTemplate<String, Student> redisTemplate;
    private HashOperations hashOps;

    @Autowired
    public StudentRedisRepository(RedisTemplate<String,Student> redisTemplate){
        this.redisTemplate = redisTemplate;
    }


    @PostConstruct
    public void init(){
        this.hashOps = this.redisTemplate.opsForHash();
    }

    public List<Student> findAll(){
        Map<String,Student> allElements = hashOps.entries(STUDENT_COLLECTION);
        return allElements.values().stream().collect(Collectors.toList());
    }

    public Student findOne(String studentId){
        return (Student) hashOps.get(STUDENT_COLLECTION, studentId);
    }

    public void addStudent(Student student){
        hashOps.put(STUDENT_COLLECTION,student.getId(),student);
    }

    public Student save(Student student){
        hashOps.put(STUDENT_COLLECTION,student.getId(),student);
        return  student;
    }

    public Student insert(Student student){
        hashOps.put(STUDENT_COLLECTION,student.getId(),student);
        return  student;
    }

    public void delete(Long id){
        hashOps.delete(STUDENT_COLLECTION,id);

    }



}
