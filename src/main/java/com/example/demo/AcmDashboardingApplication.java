package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableWebMvc
@EnableSwagger2
public class AcmDashboardingApplication {

	public static void main(String[] args) {

		SpringApplication.run(AcmDashboardingApplication.class, args);
	}
}
