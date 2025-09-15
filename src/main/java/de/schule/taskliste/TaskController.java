package de.schule.taskliste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Erlaubt Anfragen von überall (wichtig fürs Frontend, sonst CORS-Fehler)
@CrossOrigin(origins = "*")
// Markiert diese Klasse als REST-Controller
@RestController
// Alle Routen starten mit /tasks
@RequestMapping("/tasks")
public class TaskController {

    // Zugriff auf die Datenbank über TaskRepository
    @Autowired
    private TaskRepository repo;

    // GET: Alle Aufgaben abrufen
    @GetMapping
    public List<Task> getTasks() {
        return repo.findAll();
    }

    // POST: Neue Aufgabe hinzufügen
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return repo.save(task);
    }

    // PUT: Vorhandene Aufgabe aktualisieren (Titel, Beschreibung, erledigt-Status, etc.)
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return repo.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setDone(updatedTask.isDone());
            return repo.save(task);
        }).orElseThrow();
    }

    // DELETE: Aufgabe löschen
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

// Extra Controller für die Startseite
@RestController
class RootController {
    @GetMapping("/")
    public String root() {
        return "Taskliste Backend läuft!";
    }
}
