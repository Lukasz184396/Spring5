package com.zawadal.spring5didemo;

import com.zawadal.spring5didemo.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5didemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Spring5didemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		controller.hello();
	}
}
