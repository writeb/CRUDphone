package com.example.demo.repositorySecond;

import com.example.demo.modelSecond.Employee;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {

    Employee findByEmail(String email);
    Employee findEmployeeById(ObjectId id);

}
