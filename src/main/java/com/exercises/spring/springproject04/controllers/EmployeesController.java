package com.exercises.spring.springproject04.controllers;

import com.exercises.spring.springproject04.entities.EmployeeEntity;
import com.exercises.spring.springproject04.services.EmployeeServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeesController {

    @Autowired
    private EmployeeServiceDao employeeService;

//    @RequestMapping("/spring-web/{symbolicName:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{extension:\\.[a-z]+}")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllUser( Model model) {
        List<EmployeeEntity> employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);
        return "employee/employeeList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddEmplFrom(Model model) {
        model.addAttribute("employee", new EmployeeEntity());
        return "addEmployee";
    }
}
