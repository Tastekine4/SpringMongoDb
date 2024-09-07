package com.tastekine.workshop_mongodb.workshop1;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {


}
