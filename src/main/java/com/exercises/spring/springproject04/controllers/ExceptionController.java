package com.exercises.spring.springproject04.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView getDefaultError(Exception ex) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("errorMessage", ex.getMessage());
        return model;
    }
}
