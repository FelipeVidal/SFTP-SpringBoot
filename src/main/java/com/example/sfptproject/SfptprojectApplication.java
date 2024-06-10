package com.example.sfptproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.controller","com.example.utils","com.example.services","com.example.cron"})
@SpringBootApplication
public class SfptprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SfptprojectApplication.class, args);
	}

}
