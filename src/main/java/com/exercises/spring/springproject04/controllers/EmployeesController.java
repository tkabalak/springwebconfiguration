package com.exercises.spring.springproject04.controllers;

import com.exercises.spring.springproject04.dto.CustomUserDetails;
import com.exercises.spring.springproject04.entities.EmployeeEntity;
import com.exercises.spring.springproject04.services.EmployeeServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeesController {

    @Autowired
    private EmployeeServiceDao employeeService;



    @Autowired
    private Long getLong;

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
        return "employee/addEmployee";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String getAddEmplFromPOST(@ModelAttribute("employee") EmployeeEntity employee,
                                     @AuthenticationPrincipal CustomUserDetails customUser,
                                     BindingResult result,
                                     Model model) {
        String toString = employee.toString();
        //employeeService.saveEmployee(employee);
        return "employee/addEmployee";
    }


}
