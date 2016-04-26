package com.exercises.spring.springproject04.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Document(collection = "employee")
public class Task {
    @Id
    private Long taskId;
    private String title;
    private LocalDate added;
    private LocalDate expire;
    private List<Progress> progress;
    {
        Progress p1 = progress.get(0);

    }
}
