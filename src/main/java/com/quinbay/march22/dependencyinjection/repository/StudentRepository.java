package com.quinbay.march22.dependencyinjection.repository;

import com.quinbay.march22.dependencyinjection.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
}
