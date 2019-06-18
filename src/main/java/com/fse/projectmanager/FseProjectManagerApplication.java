package com.fse.projectmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FseProjectManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FseProjectManagerApplication.class, args);
		System.out.println("Hello : Spring Boot Statup project is working");
	}

}
