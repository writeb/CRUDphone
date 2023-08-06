package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;


@Getter
@Setter
public class EmployeeDTO {
    private ObjectId id;
    private String email;
    private String password;
    private String fullName;
    private String birthYear;
    private String firstPhone;
    private String secondPhone;
    private String createdAt;
}