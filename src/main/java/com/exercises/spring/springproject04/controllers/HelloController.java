
package com.exercises.spring.springproject04.controllers;

import com.exercises.spring.springproject04.entities.TaskEntity;
import com.exercises.spring.springproject04.services.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private TaskServiceImpl taskService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(Model model) {
        model.addAttribute("msg", "Super Strona");
        return "index";
    }

    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView simple(Model model) {
        return new ModelAndView("index", "msg", "Siema");
    }

    @RequestMapping(value = "/listazadan")
    public String getList(Model model){
        List<Zadanie> zadania = Arrays.asList(new Zadanie("Zadanie 1", "Zadanie 1 Tytuł"));
        model.addAttribute("zadania", zadania);
        return "table";
    }
    @RequestMapping(value = "/listazadannew")
    public String getListNew(Model model){
        List<TaskEntity> zadania = taskService.findAllTask();
        System.out.println(zadania != null);
        System.out.println(zadania.size());
        System.out.println(zadania.get(0).toString());
        model.addAttribute("zadania", zadania);

        return "dashboard";
    }

    public class Zadanie {
        private String name;
        private String title;

        public Zadanie() {
        }

        public Zadanie(String name, String title) {
            this.name = name;
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
