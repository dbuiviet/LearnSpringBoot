package com.dbuiviet.spring.learnSpringBoot.controller;

import com.dbuiviet.spring.learnSpringBoot.model.ToDo;
import com.dbuiviet.spring.learnSpringBoot.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class ToDoController {
    @Autowired
    ToDoService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showListToDoPage(ModelMap model){
        String name = (String) model.get("name");
        model.put("todos", service.retrieveToDos(name));

        return "list-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddToDoPage(ModelMap model){
        model.addAttribute("addToDo", new ToDo(0, (String) model.get("name"), "Default Desc",
                new Date(), false));

        return "add-todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addToDo(ModelMap model, @Valid @ModelAttribute("addToDo") ToDo todo, BindingResult result){
        if (result.hasErrors()){
            return "add-todo";
        }

        model.put("desc", todo.getDesc());
        model.put("deadline", todo.getDeadline());
        String name = (String) model.get("name");

        service.addToDo(name, todo.getDesc(), todo.getDeadline(),false);

        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteToDo(@RequestParam int id){

        service.deleteToDo(id);

        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateToDoPage(ModelMap model, @RequestParam int id){

        ToDo todo = service.getToDo(id);

        model.put("addToDo", todo);

        return "add-todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateToDo(ModelMap model, @Valid @ModelAttribute("addToDo") ToDo todo, BindingResult result){

        if (result.hasErrors()){
            return "add-todo";
        }

        todo.setUser((String) model.get("name"));

        service.updateToDo(todo);

        return "redirect:/list-todos";
    }
}
