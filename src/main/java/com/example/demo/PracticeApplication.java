package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.*"})
public class PracticeApplication {

	public static void main(String[] args) {
	  ApplicationContext ctx=	SpringApplication.run(PracticeApplication.class, args);
	  
	 
	}
}
