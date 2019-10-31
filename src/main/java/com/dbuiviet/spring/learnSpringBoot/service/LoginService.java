package com.dbuiviet.spring.learnSpringBoot.service;

import org.springframework.stereotype.Component;

//Spring Bean
@Component
public class LoginService {

    public boolean validateUser(String userid, String password){
        //hard-coded credential
        return userid.equalsIgnoreCase("dbuiviet")
                && password.equalsIgnoreCase("9121981");
    }
}
