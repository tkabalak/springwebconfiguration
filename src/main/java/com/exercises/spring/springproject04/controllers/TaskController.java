package com.exercises.spring.springproject04.controllers;

import com.exercises.spring.springproject04.config.Status;
import com.exercises.spring.springproject04.dto.CustomUserDetails;
import com.exercises.spring.springproject04.entities.EmployeeEntity;
import com.exercises.spring.springproject04.entities.TaskEntity;
import com.exercises.spring.springproject04.services.EmployeeServiceDao;
import com.exercises.spring.springproject04.services.LoggerService;
import com.exercises.spring.springproject04.services.TaskServiceDao;
import com.exercises.spring.springproject04.services.TaskServiceImpl;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @Autowired
    private TaskServiceDao taskServiceDao;

    @Autowired
    private EmployeeServiceDao employeeService;

    @Autowired
    private LoggerService logger;

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public String getCurrentUserTaskList(@AuthenticationPrincipal CustomUserDetails customUser,
                                         Model model){
        return taskList(customUser.getId(), model);
    }

    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    @PreAuthorize("principal.id == #c.longValue()") // :TODO add "hasRole(user)
    public String getTaskListForUser(@PathVariable @P("c") Long userId,
                                     @AuthenticationPrincipal CustomUserDetails customUser,
                                     Model model){
        logger.log("getTaskListForUser", Level.DEBUG);

        if (userId.equals(customUser.getId())) {
            return "redirect:/task/my";
        } else {
            return taskList(userId, model);
        }
    }

    private String taskList(Long userId, Model model){
        List<TaskEntity> tasks = taskService.findAllTaskForUser(userId);
        model.addAttribute("zadania", tasks);
        return  "task/taskList";
    }

    @RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
    public String getTaskById(@PathVariable Long taskId, Model mOdel){
        Optional<TaskEntity> task = taskService.findTask(taskId);

        if (task.isPresent()){
            // :TODO move status check to service
            // :TODO add status values enum
            TaskEntity taskEntity = task.get();
            if (Status.compare(Status.GIVEN, taskEntity.getStatus())) {
                taskServiceDao.updateStatus(taskEntity.getIdTask(), (short) Status.RECEIVE.getVal());
            }
            mOdel.addAttribute("zadanie", taskEntity);
            EmployeeEntity manager = employeeService.findEmployeeById(taskEntity.getManagerId());
            mOdel.addAttribute("manager", manager);
            return "task/details";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("taskEntity") TaskEntity taskEntity,
                          @AuthenticationPrincipal CustomUserDetails customUser,
                          BindingResult result,
                          Model model){
        if(!result.hasErrors()) {
            taskEntity.setManagerId(customUser.getId());
            taskService.save(taskEntity);
            return "redirect:/task/my";
        } else {
            return getAddForm(model);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddForm(Model model){
        model.addAttribute("taskEntity", new TaskEntity());
        return "task/addTask";
    }


    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }

    @RequestMapping("/messages/inbox")
    @ResponseBody
    public String findMessagesForUser(@AuthenticationPrincipal UserDetails customUser) {
        return customUser.getUsername();
        // .. find messags for this user and return them ...
    }

    @RequestMapping(value = "/messages/elo", produces = "text/plain")
    public @ResponseBody String findUserDetails(@AuthenticationPrincipal CustomUserDetails customUser) {
        return customUser.toString();
    }
}
