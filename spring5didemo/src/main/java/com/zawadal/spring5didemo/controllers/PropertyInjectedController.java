package com.zawadal.spring5didemo.controllers;


import com.zawadal.spring5didemo.services.GreetingServiceImp;

public class PropertyInjectedController {

    public GreetingServiceImp greetingService;

    String sayHallo(){
        return greetingService.sayGreeting();
    }
}
