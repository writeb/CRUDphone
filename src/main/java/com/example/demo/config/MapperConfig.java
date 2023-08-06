package com.example.demo.config;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.modelFirst.User;
import com.example.demo.modelSecond.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapperConfig {
    @Bean
    public UserMapper userMapper(){
        return new UserMapper() {
            @Override
            public UserDTO toDto(User user) {
                if ( user == null ) {
                    return null;
                }

                UserDTO userDTO = new UserDTO();

                userDTO.setId( user.getId() );
                userDTO.setEmail( user.getEmail() );
                userDTO.setPassword( user.getPassword() );
                userDTO.setFullName( user.getFullName() );
                userDTO.setBirthYear(user.getBirthYear());
                userDTO.setFirstPhone(user.getFirstPhone());
                userDTO.setSecondPhone(user.getSecondPhone());
                userDTO.setCreatedAt(user.getCreatedAt());

                return userDTO;
            }

            @Override
            public User toModel(UserDTO userDTO) {
                if ( userDTO == null ) {
                    return null;
                }

                User user = new User();

                user.setId( userDTO.getId() );
                user.setEmail( userDTO.getEmail() );
                user.setPassword( userDTO.getPassword() );
                user.setFullName( userDTO.getFullName() );
                user.setBirthYear(userDTO.getBirthYear());
                user.setFirstPhone(userDTO.getFirstPhone());
                user.setSecondPhone(userDTO.getSecondPhone());
                user.setCreatedAt(userDTO.getCreatedAt());


                return user;
            }

            @Override
            public List<UserDTO> toDtoList(List<User> userList) {
                if ( userList == null ) {
                    return null;
                }

                List<UserDTO> list = new ArrayList<UserDTO>( userList.size() );
                for ( User user : userList ) {
                    list.add( toDto( user ) );
                }

                return list;
            }

            @Override
            public List<User> toModelList(List<UserDTO> userDTOList) {
                if ( userDTOList == null ) {
                    return null;
                }

                List<User> list = new ArrayList<User>( userDTOList.size() );
                for ( UserDTO userDTO : userDTOList ) {
                    list.add( toModel( userDTO ) );
                }

                return list;
            }
        };
    }

    @Bean
    public EmployeeMapper employeeMapper(){
        return new EmployeeMapper() {
            @Override
            public EmployeeDTO toDto(Employee employee) {
                if ( employee == null ) {
                    return null;
                }

                EmployeeDTO employeeDTO = new EmployeeDTO();

                employeeDTO.setId( employee.getId() );
                employeeDTO.setEmail( employee.getEmail() );
                employeeDTO.setPassword( employee.getPassword() );
                employeeDTO.setFullName( employee.getFullName() );
                employeeDTO.setBirthYear(employee.getBirthYear());
                employeeDTO.setFirstPhone(employee.getFirstPhone());
                employeeDTO.setSecondPhone(employee.getSecondPhone());
                employeeDTO.setCreatedAt(employee.getCreatedAt());

                return employeeDTO;
            }

            @Override
            public Employee toModel(EmployeeDTO employeeDTO) {
                if ( employeeDTO == null ) {
                    return null;
                }

                Employee employee = new Employee();

                employee.setId( employeeDTO.getId() );
                employee.setEmail( employeeDTO.getEmail() );
                employee.setPassword( employeeDTO.getPassword() );
                employee.setFullName( employeeDTO.getFullName() );
                employee.setBirthYear(employeeDTO.getBirthYear());
                employee.setFirstPhone(employeeDTO.getFirstPhone());
                employee.setSecondPhone(employeeDTO.getSecondPhone());
                employee.setCreatedAt(employeeDTO.getCreatedAt());

                return employee;
            }

            @Override
            public List<EmployeeDTO> toDtoList(List<Employee> employeeList) {
                if ( employeeList == null ) {
                    return null;
                }

                List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( employeeList.size() );
                for ( Employee employee : employeeList ) {
                    list.add( toDto( employee ) );
                }

                return list;
            }

            @Override
            public List<Employee> toModelList(List<EmployeeDTO> employeeDTOList) {
                if ( employeeDTOList == null ) {
                    return null;
                }

                List<Employee> list = new ArrayList<Employee>( employeeDTOList.size() );
                for ( EmployeeDTO employeeDTO : employeeDTOList ) {
                    list.add( toModel( employeeDTO ) );
                }

                return list;
            }
        };
    }
}
