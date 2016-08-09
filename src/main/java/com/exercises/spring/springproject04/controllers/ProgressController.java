package com.exercises.spring.springproject04.controllers;

import com.exercises.spring.springproject04.entities.ProgressEntity;
import com.exercises.spring.springproject04.services.ProgressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("progress")
public class ProgressController {
    @Autowired
    private ProgressServiceImpl progressService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String getProgressFrom(@ModelAttribute("progress") ProgressEntity progress,
                                                Model uiModel){
        try {
            progressService.save(progress);
            uiModel.addAttribute("msg", "PROGRESS ADDED");
            return "redirect:/task/" + progress.getIdTask();
        } catch (Exception ex) {
            Logger.getLogger("test").log(Level.SEVERE, ex.getMessage());
            uiModel.addAttribute("msg", "dodawanie nie powiodło sie + " + ex.getMessage());
            return "redirect:/task/" + progress.getIdTask();
        }
    }
}
