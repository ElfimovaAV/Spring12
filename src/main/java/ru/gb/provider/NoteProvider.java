package ru.gb.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.model.Note;
import ru.gb.subscriber.NoteSubscriber;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class NoteProvider {
    protected List<NoteSubscriber> subscriberList = new ArrayList<>();
    public void registerSubscriber(NoteSubscriber subscriber) {
        if(!subscriberList.contains(subscriber)) {
            subscriberList.add(subscriber);
        }
    }
    public void unsubscribe(NoteSubscriber subscriber) {
        subscriberList.remove(subscriber);

    }
    public void notifySubscriber(Note note) {
        for (NoteSubscriber subscriber : subscriberList) {
            subscriber.updateSubscriber(note);
        }

    }
}
