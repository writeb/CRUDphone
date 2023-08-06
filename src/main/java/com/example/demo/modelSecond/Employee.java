package com.example.demo.modelSecond;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "employee")
@Getter
@Setter
public class Employee {
    @Id
    private String id;

    private String fullName;

    private String email;

    private String password;

    private LocalDate birthYear;

    private String firstPhone;

    private String secondPhone;

    private LocalDate createdAt;
}

