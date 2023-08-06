package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.modelSecond.Employee;
import com.example.demo.repositorySecond.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
            employeeDTO.setCreatedAt(LocalDate.now());
            return employeeMapper.toDto(employeeRepository.save(employeeMapper.toModel(employeeDTO)));
        }
        return null;
    }

    public List<EmployeeDTO> getEmployees(){
        return employeeMapper.toDtoList(employeeRepository.findAll());
    }

    public EmployeeDTO getEmployeeById(String id){
        return employeeMapper.toDto(employeeRepository.findEmployeeById(id));
    }

    public EmployeeDTO updateEmployee(String id, EmployeeDTO employeeDTO){
        EmployeeDTO oldEmployeeDTO = employeeMapper.toDto(employeeRepository.findById(id).orElse(null));
        if (oldEmployeeDTO!=null){
            oldEmployeeDTO.setEmail(employeeDTO.getEmail());
            oldEmployeeDTO.setFullName(employeeDTO.getFullName());
            oldEmployeeDTO.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
            oldEmployeeDTO.setBirthYear(employeeDTO.getBirthYear());
            oldEmployeeDTO.setFirstPhone(employeeDTO.getFirstPhone());
            oldEmployeeDTO.setSecondPhone(employeeDTO.getSecondPhone());
            oldEmployeeDTO.setCreatedAt(oldEmployeeDTO.getCreatedAt());
            return employeeMapper.toDto(employeeRepository.save(employeeMapper.toModel(oldEmployeeDTO)));
        }
        return null;
    }

    public void deleteEmployee(String id){
        employeeRepository.deleteById(id);
    }

    public Page<EmployeeDTO> getEmployeesByLimitOffset(Pageable pageable){
        Page<Employee> employees = employeeRepository.findAll(pageable);
        return employees.map(employeeMapper::toDto);
    }

}
