
package com.exercises.spring.springproject04.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(Model model) {
        model.addAttribute("msg", "Super Strona");
        return "index";
    }

    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView simple(Model model) {
        return new ModelAndView("index", "msg", "Siema");
    }


}
