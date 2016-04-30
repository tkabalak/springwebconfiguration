package com.exercises.spring.springproject04.controllers;

import com.exercises.spring.springproject04.entities.TaskEntity;
import com.exercises.spring.springproject04.services.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    public String getTaskListForUser(@PathVariable Long userId, Model model){
        List<TaskEntity> tasks = taskService.findAllTaskForUser(userId);
        model.addAttribute("zadania", tasks);
        return  "task/taskList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("taskEntity") TaskEntity taskEntity){
        taskEntity.setManagerId(new Long(1));
        taskService.save(taskEntity);
        return "redirect:/list/1";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddForm(Model model){
        model.addAttribute("taskEntity", new TaskEntity());
        return "task/addTask";
    }
}
