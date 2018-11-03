package com.zawadal.spring5didemo.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImp implements GreetingService {

    public static final String HELLO_GURUS = "Hello Gurus!!!";

    @Override
    public String sayGreeting() {
        return HELLO_GURUS;
    }
}
