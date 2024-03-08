package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
