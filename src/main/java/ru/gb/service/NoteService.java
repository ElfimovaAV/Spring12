package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.model.Note;
import ru.gb.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;

    /**
     * Метод для получения списка всех заметок
     * @return все заметки
     */
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    /**
     * Метод для создания заметки
     * @param note
     * @return сохраненную заметку
     */
    public Note createNote(Note note) {
        return repository.save(note);
    }

    /**
     * Метод для получения заметки по id
     * @param id
     * @return заметку с заданным id или null
     */
    public Note getNoteById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    /**
     * Метод для редактирования заметки
     * @param note
     * @return отредактированную заметку
     */
    public Note updateNote(Long id, Note note) {
        Optional<Note> optionalNote = repository.findById(id);
        if (optionalNote.isPresent()) {
            Note noteById = optionalNote.get();
            noteById.setTitle(note.getTitle());
            noteById.setDescription(note.getDescription());
            return repository.save(noteById);
        }  else {
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
    }

    /**
     * Метод для удаления заметки
     * @param id
     */
    public void deleteNote(Long id) {
        Note noteById = getNoteById(id);
        repository.delete(noteById);
    }
}
