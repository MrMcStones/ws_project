package com.rasmus.ws_project.ws_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Huvudklass för app
@SpringBootApplication
public class TodoAppApplication {

	// Metod som startar app med Spring Boot
	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

}
