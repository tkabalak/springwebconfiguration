package com.exercises.spring.springproject04.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "employee")
public class Progress {
    @Id
    private Long progressId;
    private String comment;
    private LocalDateTime addedDate;
    private int performPercentage;

}
