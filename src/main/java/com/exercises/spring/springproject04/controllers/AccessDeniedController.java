package com.exercises.spring.springproject04.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
public class AccessDeniedController {

    @RequestMapping("/error")
    public String accessDeniedPage(Model model){

        return "accessDenied";
    }
}
