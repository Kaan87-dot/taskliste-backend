package de.schule.taskliste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TasklisteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasklisteApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(TaskRepository repo) {
		return args -> {
			repo.save(new Task("Beispiel 1"));
			repo.save(new Task("Beispiel 2"));
		};
	}
}
