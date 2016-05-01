package com.exercises.spring.springproject04.controllers;

import com.exercises.spring.springproject04.entities.EmployeeEntity;
import com.exercises.spring.springproject04.services.EmployeeServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private EmployeeServiceDao employeeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUserProfile(@PathVariable("id") Long id, Model model) {
        EmployeeEntity employeee = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employeee);
        return "employee/userProfile";
    }
}
