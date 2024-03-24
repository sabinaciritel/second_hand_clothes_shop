package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the Spring Boot application.

 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * Main method which serves as the entry point for the Spring Boot application.
	 *
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}