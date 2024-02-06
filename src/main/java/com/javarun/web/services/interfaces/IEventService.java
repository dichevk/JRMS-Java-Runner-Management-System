package main.java.com.javarun.web.services.interfaces;

import java.util.List;
import java.util.Optional;
import com.javarun.web.dto.EventDto;;

public interface IEventService {
    /**
     * Get a list of all events.
     *
     * @return A list of EventDto representing all events.
     */
    List<EventDto> getAllEvents();

    /**
     * Get details of a specific event by its ID.
     *
     * @param eventId The ID of the event to retrieve.
     * @return The EventDto representing the requested event, or an empty Optional if not found.
     */
    Optional<EventDto> getEventById(Long eventId);

    /**
     * Create a new event associated with a specific team.
     *
     * @param eventDto The EventDto representing the new event.
     * @param teamId The ID of the team associated with the event.
     */
    void createEvent(EventDto eventDto, Long teamId);

    /**
     * Delete an event by its ID.
     *
     * @param eventId The ID of the event to delete.
     */
    void deleteEvent(Long eventId);

    /**
     * Update the details of an existing event.
     *
     * @param eventDto The EventDto representing the updated event details.
     */
    void updateEvent(EventDto eventDto);
}
