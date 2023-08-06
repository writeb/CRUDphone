package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.modelSecond.Employee;
import com.example.demo.repositorySecond.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepository.findByEmail(employeeDTO.getEmail()) == null) {
            employeeDTO.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
            employeeDTO.setCreatedAt(Timestamp.from(Instant.now()));
            return employeeMapper.toDto(employeeRepository.save(employeeMapper.toModel(employeeDTO)));
        }
        return null;
    }

    public Employee addEmployeeWithoutDTO(Employee employee){
        if (employeeRepository.findByEmail(employee.getEmail()) == null) {
//            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            employee.setCreatedAt(Timestamp.from(Instant.now()));
            return employeeRepository.save(employee);
        }
        return null;
    }


    public List<EmployeeDTO> getEmployees(){
        return employeeMapper.toDtoList(employeeRepository.findAll());
    }
}
