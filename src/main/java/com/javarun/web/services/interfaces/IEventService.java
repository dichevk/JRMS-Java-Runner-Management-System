package main.java.com.javarun.web.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface IEventService {
    List<Event> getAllEvents();

    Optional<Event> getEventById(Long eventId);

    void saveEvent(Event event);

    void deleteEvent(Long eventId);
}
