package com.example.demo.repositorySecond;

import com.example.demo.modelSecond.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
    Employee findEmployeeById(Long id);

//    @Query("select emp from Employee emp")
//    List<Employee> getEmployeesByLimitOffset(Filt);
}
