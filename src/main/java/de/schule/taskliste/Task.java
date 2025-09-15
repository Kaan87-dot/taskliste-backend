package de.schule.taskliste;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;

// Diese Klasse ist ein JPA-Entity = wird als Tabelle in der Datenbank gespeichert
@Entity
public class Task {

    // Primärschlüssel (ID), wird automatisch hochgezählt
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Titel der Aufgabe
    private String title;

    // Beschreibung der Aufgabe
    private String description;

    // Status: erledigt oder nicht
    private boolean done;

    // Fälligkeitsdatum
    private LocalDate dueDate;

    // Leerer Konstruktor (wichtig für JPA)
    public Task() {}

    // Konstruktor zum schnellen Erstellen von Aufgaben
    public Task(String title, String description, boolean done, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
    }

    // Getter und Setter = Methoden, um auf die Felder zuzugreifen und sie zu ändern
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
}
