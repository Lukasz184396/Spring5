package com.zawadal.spring5didemo.controllers;

import com.zawadal.spring5didemo.services.GreetingService;
import com.zawadal.spring5didemo.services.GreetingServiceImp;

public class SetterInjectedController {

    private GreetingService greetingService;

    String sayHello() {
        return greetingService.sayGreeting();
    }

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
