package main.java.com.javarun.web.services.interfaces;

import java.util.List;
import java.util.Optional;
import com.javarun.web.dto.EventDto;;

public interface IEventService {
    List<EventDto> getAllEvents();

    Optional<EventDto> getEventById(Long eventId);

    void createEvent(EventDto eventDto, Long teamId);

    void deleteEvent(Long eventId);

    void updateEvent(EventDto eventDto);
}
