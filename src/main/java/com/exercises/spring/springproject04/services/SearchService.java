package com.exercises.spring.springproject04.services;

import com.exercises.spring.springproject04.entities.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private EmployeeServiceDao employeeService;


    public List<EmployeeEntity> search(String name){
        return employeeService.searchByName(name)
                .stream().filter(e -> (e.getName().toLowerCase() + e.getSurname().toLowerCase()).contains(name) )
                .collect(Collectors.toList());
    }
}
