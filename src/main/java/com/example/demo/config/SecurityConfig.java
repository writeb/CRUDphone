package com.example.demo.config;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.modelFirst.User;
import com.example.demo.modelSecond.Employee;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserMapper userMapper(){
        return new UserMapper() {
            @Override
            public UserDTO toDto(User user) {
                return null;
            }

            @Override
            public User toModel(UserDTO userDTO) {
                return null;
            }

            @Override
            public List<UserDTO> toDtoList(List<User> userList) {
                return null;
            }

            @Override
            public List<User> toModelList(List<UserDTO> userDTOList) {
                return null;
            }
        };
    }

    @Bean
    public EmployeeMapper employeeMapper(){
        return new EmployeeMapper() {
            @Override
            public EmployeeDTO toDto(Employee employee) {
                return null;
            }

            @Override
            public Employee toModel(EmployeeDTO employeeDTO) {
                return null;
            }

            @Override
            public List<EmployeeDTO> toDtoList(List<Employee> employeeList) {
                return null;
            }

            @Override
            public List<Employee> toModelList(List<EmployeeDTO> employeeDTOList) {
                return null;
            }
        };
    }

    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        AuthenticationManagerBuilder builder =
                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userService).passwordEncoder(passwordEncoder());

        httpSecurity
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/auth")
                .usernameParameter("user_email")
                .passwordParameter("user_password")
                .defaultSuccessUrl("/")
                .failureUrl("/login?autherror");

        httpSecurity
                .logout()
                .logoutUrl("/log-out")
                .logoutSuccessUrl("/login");

        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }
}
