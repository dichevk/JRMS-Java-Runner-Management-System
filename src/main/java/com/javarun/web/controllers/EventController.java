package main.java.com.javarun.web.controllers;

import com.javarun.web.dto.EventDto;
import com.javarun.web.services.interfaces.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing events.
 */
@RestController
@RequestMapping("/events")
public class EventController {

    private final IEventService eventService;

    /**
     * Constructor to inject the EventService dependency.
     *
     * @param eventService The EventService instance to be injected.
     */
    @Autowired
    public EventController(IEventService eventService) {
        this.eventService = eventService;
    }

    /**
     * Get a list of all events.
     *
     * @return A list of EventDto representing all events.
     */
    @GetMapping
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    /**
     * Get details of a specific event by its ID.
     *
     * @param eventId The ID of the event to retrieve.
     * @return The EventDto representing the requested event, or null if not found.
     */
    @GetMapping("/{eventId}")
    public EventDto getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId).orElse(null);
    }

    /**
     * Create a new event associated with a specific team.
     *
     * @param eventDto The EventDto representing the new event.
     * @param teamId   The ID of the team associated with the event.
     */
    @PostMapping("/{teamId}")
    public void createEvent(@RequestBody EventDto eventDto, @PathVariable Long teamId) {
        eventService.createEvent(eventDto, teamId);
    }

    /**
     * Delete an event by its ID.
     *
     * @param eventId The ID of the event to delete.
     */
    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
    }

    /**
     * Update the details of an existing event.
     *
     * @param eventDto The EventDto representing the updated event details.
     */
    @PutMapping
    public void updateEvent(@RequestBody EventDto eventDto) {
        eventService.updateEvent(eventDto);
    }
}
