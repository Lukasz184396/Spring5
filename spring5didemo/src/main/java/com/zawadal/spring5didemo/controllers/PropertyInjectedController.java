package com.zawadal.spring5didemo.controllers;


import com.zawadal.spring5didemo.services.GreetingService;
import com.zawadal.spring5didemo.services.GreetingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired
    @Qualifier("greetingServiceImp")
    public GreetingService greetingServiceImp;
    //public GreetingService greetingService;   // it will fail because of type
    //public GreetingService greetingServiceImp;   // name is ok

    public String sayHallo(){
        return greetingServiceImp.sayGreeting();
    }
}
