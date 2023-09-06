package com.retroprogamacion.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.retroprogamacion")
public class RetroprogramacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetroprogramacionApplication.class, args);
	}

}
