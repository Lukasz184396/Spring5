package com.zawadal.spring5didemo.controllers;

import com.zawadal.spring5didemo.services.GreetingService;
import com.zawadal.spring5didemo.services.GreetingServiceImp;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetterInjectedControllerTest {

    private SetterInjectedController setterInjectedController;

    @Before
    public void setUp(){
        this.setterInjectedController = new SetterInjectedController();
        this.setterInjectedController.setGreetingService(new GreetingServiceImp());
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImp.HELLO_GURUS, setterInjectedController.sayHello());
    }

}