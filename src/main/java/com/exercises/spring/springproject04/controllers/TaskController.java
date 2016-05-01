package com.exercises.spring.springproject04.controllers;

import com.exercises.spring.springproject04.entities.EmployeeEntity;
import com.exercises.spring.springproject04.entities.TaskEntity;
import com.exercises.spring.springproject04.services.EmployeeServiceDao;
import com.exercises.spring.springproject04.services.LoggerService;
import com.exercises.spring.springproject04.services.TaskServiceImpl;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @Autowired
    private EmployeeServiceDao employeeService;

    @Autowired
    private LoggerService logger;

    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    public String getTaskListForUser(@PathVariable Long userId, Model model){
        logger.log("getTaskListForUser", Level.DEBUG);
        List<TaskEntity> tasks = taskService.findAllTaskForUser(userId);
        model.addAttribute("zadania", tasks);
        return  "task/taskList";
    }

    @RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
    public String getTaskById(@PathVariable Long taskId, Model mOdel){
        Optional<TaskEntity> task = taskService.findTask(taskId);
        if (task.isPresent()){
            mOdel.addAttribute("zadanie", task.get());
            EmployeeEntity manager = employeeService.findEmployeeById(task.get().getManagerId());
            mOdel.addAttribute("manager", manager);
            return "task/details";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("taskEntity") TaskEntity taskEntity){
        taskEntity.setManagerId(new Long(1));
        taskService.save(taskEntity);
        return "redirect:/task/list/1";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddForm(Model model){
        model.addAttribute("taskEntity", new TaskEntity());
        return "task/addTask";
    }
}
