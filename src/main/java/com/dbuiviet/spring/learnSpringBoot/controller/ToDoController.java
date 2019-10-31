package com.dbuiviet.spring.learnSpringBoot.controller;

import com.dbuiviet.spring.learnSpringBoot.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ToDoController {
    @Autowired
    ToDoService service;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showListToDo(ModelMap model){
        model.put("todos", service.retrieveToDos("dbuiviet"));

        return "list-todos";
    }
}
