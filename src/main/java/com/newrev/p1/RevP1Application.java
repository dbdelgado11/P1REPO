package com.newrev.p1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RevP1Application {

	public static void main(String[] args) {
		SpringApplication.run(RevP1Application.class, args);
	}

}
