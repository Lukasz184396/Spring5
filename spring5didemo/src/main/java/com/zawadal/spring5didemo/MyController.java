package com.zawadal.spring5didemo;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String hello() {
        System.out.println("Hello!!!");
        return "foo";
    }
}
