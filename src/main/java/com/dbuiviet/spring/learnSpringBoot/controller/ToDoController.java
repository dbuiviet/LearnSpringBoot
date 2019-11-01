package com.dbuiviet.spring.learnSpringBoot.controller;

import com.dbuiviet.spring.learnSpringBoot.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("name")
public class ToDoController {
    @Autowired
    ToDoService service;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showListToDoPage(ModelMap model){
        String name = (String) model.get("name");
        model.put("todos", service.retrieveToDos(name));

        return "list-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddToDoPage(ModelMap model){

        return "add-todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addToDo(ModelMap model, @RequestParam String desc){
        model.put("desc", desc);
        String name = (String) model.get("name");

        service.addToDo(name, desc, new Date(),false);

        return "redirect:/list-todos";
    }
}
