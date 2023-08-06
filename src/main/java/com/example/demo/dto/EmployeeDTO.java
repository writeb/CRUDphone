package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class EmployeeDTO {
    private String id;
    private String email;
    private String password;
    private String fullName;
    private LocalDate birthYear;
    private String firstPhone;
    private String secondPhone;
    private LocalDate createdAt;
}