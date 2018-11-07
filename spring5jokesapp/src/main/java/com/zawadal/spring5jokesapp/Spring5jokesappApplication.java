package com.zawadal.spring5jokesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.Resource;

@SpringBootApplication
@ImportResource("classpath:chuck-config.xml")
public class Spring5jokesappApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5jokesappApplication.class, args);
	}
}
