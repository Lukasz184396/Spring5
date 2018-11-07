package com.zawadal.spring5didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class PrimayGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public PrimayGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getEnglishGreeting();
    }
}
