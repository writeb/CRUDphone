package com.example.demo.mapper;


import com.example.demo.modelSecond.Employee;
import com.example.demo.dto.EmployeeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDto(Employee employee);
    Employee toModel(EmployeeDTO employeeDTO);
    List<EmployeeDTO> toDtoList(List<Employee> employeeList);
    List<Employee>  toModelList(List<EmployeeDTO> employeeDTOList);
}
