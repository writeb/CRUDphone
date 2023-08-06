package com.example.demo.modelSecond;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "t_employees")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "birth_year")
    private LocalDate birthYear;

    @Column(name = "first_phone")
    private String firstPhone;

    @Column(name = "second_phone")
    private String secondPhone;

    @Column(name = "created_at")
    private Timestamp createdAt;
}

