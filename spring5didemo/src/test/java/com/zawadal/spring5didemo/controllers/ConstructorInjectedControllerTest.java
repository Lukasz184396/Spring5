package com.zawadal.spring5didemo.controllers;

import com.zawadal.spring5didemo.services.GreetingServiceImp;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructorInjectedControllerTest {

    private ConstructorInjectedController constructorInjectedController;

    @Before
    public void setUp() {
        this.constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImp());
    }

    @Test
    public void testGreeting() {
        assertEquals(GreetingServiceImp.HELLO_GURUS, constructorInjectedController.sayHello());
    }

}