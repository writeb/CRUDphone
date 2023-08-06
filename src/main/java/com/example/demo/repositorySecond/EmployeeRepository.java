package com.example.demo.repositorySecond;

import com.example.demo.modelSecond.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Employee findByEmail(String email);
    Employee findEmployeeById(String id);

}
