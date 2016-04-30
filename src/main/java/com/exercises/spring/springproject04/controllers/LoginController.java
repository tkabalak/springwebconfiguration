package com.exercises.spring.springproject04.controllers;

import com.exercises.spring.springproject04.entities.LoginEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm(Model model){
        model.addAttribute("user", new LoginEntity());
        return "login";
    }
}
