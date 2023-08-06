package com.example.demo.api;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public EmployeeDTO getEmployeeById(@PathVariable(name = "id") String id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping(value = "{id}")
    public EmployeeDTO updateEmployee(@PathVariable(name = "id") String id, @RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping(value = "{id}")
    public void deleteEmployee(@PathVariable(name = "id") String id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping(value = "{limit}/{offset}")
    public Page<EmployeeDTO> getEmployeesByLimitOffset(@PathVariable(name = "limit") int limit,
                                               @PathVariable(name = "offset") int offset){
        Pageable pageable = PageRequest.of(offset, limit);
        return employeeService.getEmployeesByLimitOffset(pageable);
    }

}
