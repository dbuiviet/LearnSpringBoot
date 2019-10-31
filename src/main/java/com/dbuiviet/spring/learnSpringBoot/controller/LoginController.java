package com.dbuiviet.spring.learnSpringBoot.controller;

import com.dbuiviet.spring.learnSpringBoot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    //instantiated automatically
    @Autowired
    LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    //@ResponseBody
    //public String loginMessage(@RequestParam String name, ModelMap modelMap) {
    public String showLoginPage( ModelMap modelMap) {
        //MVC : Model - View - Controller
        //modelMap.put("name", name);
        //System.out.println("name is " + name);

        //return name of the view to look for (with prefix and suffix in application properties
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //public String loginMessage(@RequestParam String name, ModelMap modelMap) {
    public String showWelcomePage( ModelMap modelMap, @RequestParam String name, @RequestParam String password) {
        modelMap.put("name", name);
        modelMap.put("password", password);

        boolean isValidUser = service.validateUser(name, password);
        if (!isValidUser){
            modelMap.put("invalidMsg", "Wrong login credentials! Please re-enter.");
            return "login";
        }

        return "welcome";
    }
}
