package de.schule.taskliste;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping
    public List<Task> getTasks() {
        return List.of(
                new Task(1L, "Test", "Beispiel-Task", false),
                new Task(2L, "Noch ein Task", "Beschreibung", true)
        );
    }

}


@RestController
class RootController {
    @GetMapping("/")
    public RedirectView redirectToTasks() {
        return new RedirectView("/tasks");
    }
}
