package com.example.demo.modelSecond;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
@Getter
@Setter
public class Employee {
    @Id
    private ObjectId id;

    private String fullName;

    private String email;

    private String password;

    private String birthYear;

    private String firstPhone;

    private String secondPhone;

    private String createdAt;
}

