package com.exercises.spring.springproject04.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "employee")
public class Employee {
    @Id
    private Long employeeId;
    private String username;
    private String password;
    private Person person;
    private List<Task> tasks;

}
