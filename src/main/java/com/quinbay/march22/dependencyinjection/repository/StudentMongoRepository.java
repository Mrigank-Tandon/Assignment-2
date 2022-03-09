package com.quinbay.march22.dependencyinjection.repository;

import com.quinbay.march22.dependencyinjection.entity.StudentEntityMongo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMongoRepository extends CrudRepository<StudentEntityMongo,Long> {
}
