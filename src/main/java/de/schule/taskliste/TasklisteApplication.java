package de.schule.taskliste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class TasklisteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasklisteApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(TaskRepository repository) {
		return args -> {
			repository.save(new Task("Testaufgabe", "Beschreibung", false));
			repository.save(new Task("Noch eine Aufgabe", "Zweite Beschreibung", true));
		};
	}
}
