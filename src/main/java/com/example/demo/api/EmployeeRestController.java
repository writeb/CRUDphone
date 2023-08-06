package com.example.demo.api;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping(value = "{id}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "id") ObjectId id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping(value = "{id}")
    public EmployeeDTO updateEmployee(@PathVariable(name = "id") ObjectId id, @RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping(value = "{id}")
    public void deleteEmployee(@PathVariable(name = "id") ObjectId id){
        employeeService.deleteEmployee(id);
    }

}
