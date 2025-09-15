package de.schule.taskliste;

import org.springframework.data.jpa.repository.JpaRepository;

// TaskRepository ist eine Schnittstelle zur Datenbank
// Es erbt von JpaRepository und bekommt damit automatisch viele Methoden:
// - findAll()    -> Alle Einträge aus der DB holen
// - findById()   -> Einen Eintrag nach ID suchen
// - save()       -> Einen Eintrag speichern oder aktualisieren
// - deleteById() -> Einen Eintrag löschen
public interface TaskRepository extends JpaRepository<Task, Long> {}
