package com.exercises.spring.springproject04.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "employee")
public class Person {
    @Id
    private Long personId;
    private String name;
    private String surname;
    private String email;
    private byte [] profilePhotography;

}
