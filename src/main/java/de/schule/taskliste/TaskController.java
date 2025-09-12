package de.schule.taskliste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository repo;

    // Alle Aufgaben abrufen
    @GetMapping
    public List<Task> getTasks() {
        return repo.findAll();
    }

    // Neue Aufgabe hinzufügen
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return repo.save(task);
    }

    // Aufgabe aktualisieren (z. B. erledigt-Status oder Titel ändern)
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return repo.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setDone(updatedTask.isDone());
            return repo.save(task);
        }).orElseThrow();
    }

    // Aufgabe löschen
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

// Neue Klasse außerhalb von TaskController:
@RestController
class RootController {
    @GetMapping("/")
    public String root() {
        return "Taskliste Backend läuft!";
    }
}
