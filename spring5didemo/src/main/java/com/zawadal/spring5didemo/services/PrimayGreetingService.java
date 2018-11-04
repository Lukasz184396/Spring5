package com.zawadal.spring5didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PrimayGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello - Primary Greeting service";
    }
}
