package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private LocalDate birthYear;
    private String firstPhone;
    private String secondPhone;
    private Timestamp createdAt;
}
