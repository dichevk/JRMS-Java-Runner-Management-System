package main.java.com.javarun.web.services.interfaces;

import java.util.List;
import java.util.Optional;
import com.javarun.web.dto.EventDto;;

public interface IEventService {
    /**
     * @return
     */
    List<EventDto> getAllEvents();

    /**
     * @param eventId
     * @return
     */
    Optional<EventDto> getEventById(Long eventId);

    /**
     * @param eventDto
     * @param teamId
     */
    void createEvent(EventDto eventDto, Long teamId);

    /**
     * @param eventId
     */
    void deleteEvent(Long eventId);

    /**
     * @param eventDto
     */
    void updateEvent(EventDto eventDto);
}
