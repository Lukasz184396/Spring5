package com.zawadal.spring5didemo;

import com.zawadal.spring5didemo.controllers.ConstructorInjectedController;
import com.zawadal.spring5didemo.controllers.MyController;
import com.zawadal.spring5didemo.controllers.PropertyInjectedController;
import com.zawadal.spring5didemo.controllers.SetterInjectedController;
import com.zawadal.spring5didemo.examplebeans.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5didemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Spring5didemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);

		System.out.println(fakeDataSource.getUser());
	}
}
