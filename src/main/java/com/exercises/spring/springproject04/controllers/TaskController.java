package com.exercises.spring.springproject04.controllers;

import com.exercises.spring.springproject04.config.Status;
import com.exercises.spring.springproject04.dto.CustomUserDetails;
import com.exercises.spring.springproject04.entities.EmployeeEntity;
import com.exercises.spring.springproject04.entities.ProgressEntity;
import com.exercises.spring.springproject04.entities.TaskEntity;
import com.exercises.spring.springproject04.services.*;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private SearchService searchService;

    @Autowired
    private LoggerService logger;

    @InitBinder
    public void initBinder(WebDataBinder binder) {

//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Timestamp.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public String getCurrentUserTaskList(@AuthenticationPrincipal CustomUserDetails customUser,
                                         Model model) {
        return taskList(customUser.getId(), model);
    }

    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    @PreAuthorize("principal.id == #c.longValue() or hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
    public String getTaskListForUser(@PathVariable @P("c") Long userId,
                                     @AuthenticationPrincipal CustomUserDetails customUser,
                                     Model model) {
        logger.log("getTaskListForUser", Level.DEBUG);
        if (userId.equals(customUser.getId())) {
            return "redirect:/task/my";
        } else {
            return taskList(userId, model);
        }
    }

    private String taskList(Long userId, Model model) {
        List<TaskEntity> tasks = taskService.findAllTaskForUser(userId);
        model.addAttribute("zadania", tasks);
        return "task/taskList";
    }

    @RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
    public String getTaskById(@PathVariable Long taskId, Model mOdel) {
        Optional<TaskEntity> task = taskService.findTask(taskId);

        if (task.isPresent()) {
            // :TODO move status check to service
            TaskEntity taskEntity = task.get();
            if (Status.compare(Status.GIVEN, taskEntity.getStatus())) {
                taskServiceDao.updateStatus(taskEntity.getIdTask(), Status.RECEIVE.getVal());
            }
            mOdel.addAttribute("zadanie", taskEntity);
            mOdel.addAttribute("progress", new ProgressEntity());
//            taskEntity.getManagerId().getIdEmployee()
            //EmployeeEntity manager = employeeService.findEmployeeById(taskEntity.getManagerId().getIdEmployee());
            //mOdel.addAttribute("manager", manager);
            return "task/details";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
    public String addTask(@ModelAttribute("taskEntity") TaskEntity taskEntity,
                          @AuthenticationPrincipal CustomUserDetails customUser,
                          BindingResult result,
                          Model model) {
        if (!result.hasErrors()) {
            taskEntity.setManagerId(customUser.getLogin().getEmployeeId());
            taskService.save(taskEntity);
            return "redirect:/task/my";
        } else {
            return getAddForm(model);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
    public String getAddForm(Model model) {
        model.addAttribute("taskEntity", new TaskEntity());
        return "task/addTask";
    }

    @RequestMapping(value = "/done/{taskId}")
    public String taskDone(@PathVariable("taskId") Long taskId){

        TaskEntity taskEntity = taskServiceDao.findOne(taskId);

        if( taskEntity != null)
            taskServiceDao.updateStatus(taskId, Status.DONE.getVal());


        return "redirect:/task/my";
    }

    @RequestMapping(value = "/employee/ajax",
                    method = {RequestMethod.POST ,RequestMethod.GET})
    public @ResponseBody String getAutocompleteEmployeeAjax(@RequestParam("search") String search, Model uiModel){
        if (search != null && !search.isEmpty()) {
            search = search.replace(" ", "");
            List<EmployeeEntity> searchResult = searchService.search(search.toLowerCase());
            String s = searchResult.stream()
                    .map(e -> "{ \"id\" : " + e.getIdEmployee() + ", \"name\" : \"" + e.getFullName() + "\" }")
                    .collect(Collectors.joining(",", "[", "]"));

            return s;

        }

        return ResponseEntity.badRequest().toString();
    }

    @RequestMapping(value = "/employee/ajax/2",
            method = {RequestMethod.POST ,RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    //@JsonView(EmployeeEntity.class)
    public @ResponseBody List<EmployeeEntity> getAutoAjax(@RequestParam("search") String search, Model uiModel){
        if (search != null && !search.isEmpty()) {
            search = search.replace(" ", "");
            List<EmployeeEntity> searchResult = searchService.search(search.toLowerCase());
            return searchResult;

        }

        return Collections.EMPTY_LIST;
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
    public
    @ResponseBody
    String findUserDetails(@AuthenticationPrincipal CustomUserDetails customUser) {
        return customUser.toString();
    }
}
