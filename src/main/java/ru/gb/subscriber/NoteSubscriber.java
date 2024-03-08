package ru.gb.subscriber;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.model.Note;

@Component
public class NoteSubscriber {
    private static final NoteSubscriber INSTANCE = new NoteSubscriber();

    private NoteSubscriber() {
    }

    public static NoteSubscriber getInstance() {
        return INSTANCE;
    }
    public void updateSubscriber(Note note) {
        System.out.println("Подписчик уведомлен о создании новой заметки: " + note.getTitle());
    }

}
