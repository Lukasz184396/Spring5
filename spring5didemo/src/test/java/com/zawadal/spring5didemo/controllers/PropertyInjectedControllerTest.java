package com.zawadal.spring5didemo.controllers;

import com.zawadal.spring5didemo.services.GreetingServiceImp;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyInjectedControllerTest {

    private PropertyInjectedController propertyInjectedController;

    @Before
    public void setUp() throws Exception {
        this.propertyInjectedController = new PropertyInjectedController();
        this.propertyInjectedController.greetingServiceImp = new GreetingServiceImp();
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImp.HELLO_GURUS, propertyInjectedController.sayHallo());
    }

}