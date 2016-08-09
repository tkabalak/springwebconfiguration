package com.exercises.spring.springproject04.controllers;

import com.exercises.spring.springproject04.entities.EmployeeEntity;
import com.exercises.spring.springproject04.services.EmployeeServiceDao;
import com.exercises.spring.springproject04.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = {"/", "contact"}, method = RequestMethod.GET)
    public String findPersonGET(Model uiModel) {
        uiModel.addAttribute("src", new SearchDTO());

        return "contact/findPerson";
    }

    @RequestMapping(value = "contact", method = RequestMethod.POST)
    public String findPersonPOST(@ModelAttribute("src") SearchDTO src
            , Model uiModel) {
        String search = src.getSearch();

        if (search != null && !search.isEmpty()) {
            search = search.replace(" ", "");
            List<EmployeeEntity> employees = searchService.search(search.toLowerCase());
            uiModel.addAttribute("employees", employees);
        }

        return "contact/findPerson";
    }



}
