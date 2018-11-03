package com.zawadal.spring5didemo.controllers;


import com.zawadal.spring5didemo.services.GreetingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired
    public GreetingServiceImp greetingService;

    public String sayHallo(){
        return greetingService.sayGreeting();
    }
}
