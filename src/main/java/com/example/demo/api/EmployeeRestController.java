package com.example.demo.api;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.modelSecond.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping
    public Employee addEmployee(Employee employeeDTO){
        return employeeService.addEmployeeWithoutDTO(employeeDTO);
    }
}
