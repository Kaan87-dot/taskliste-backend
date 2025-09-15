package de.schule.taskliste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication = Startpunkt der Spring-App
// Es kombiniert: @Configuration, @EnableAutoConfiguration, @ComponentScan
@SpringBootApplication
public class TasklisteApplication {

	// main-Methode = Einstiegspunkt ins Programm
	// Startet die komplette Spring Boot Anwendung
	public static void main(String[] args) {
		SpringApplication.run(TasklisteApplication.class, args);
	}

}
