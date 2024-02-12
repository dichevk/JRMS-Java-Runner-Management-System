package main.java.com.javarun.web.controllers;

import com.javarun.web.dto.EventDto;
import com.javarun.web.dto.TeamDto;
import com.javarun.web.services.interfaces.IEventService;
import com.javarun.web.services.interfaces.ITeamService;

import main.java.com.javarun.web.controllers.exceptions.*;
import main.java.com.javarun.web.services.interfaces.ITeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing events.
 */
@RestController
@EnableAsync
@RequestMapping("v1/events")
public class EventController {

    private final IEventService eventService;
    private final ITeamService teamService;

    /**
     * Constructor to inject the EventService dependency.
     *
     * @param eventService The EventService instance to be injected.
     */
    @Autowired
    public EventController(IEventService eventService, ITeamService teamService) {
        this.eventService = eventService;
        this.teamService = teamService;
    }

    /**
     * Get a list of all events.
     *
     * @return A list of EventDto representing all events.
     */
    @GetMapping
    public List<EventDto> getAllEvents()  {
        return eventService.getAllEvents();
    }

    /**
     * Get details of a specific event by its ID.
     *
     * @param eventId The ID of the event to retrieve.
     * @return The EventDto representing the requested event, or null if not found.
     */
    @GetMapping("/{eventId}")
    public EventDto getEventById(@PathVariable Long eventId) throws EntityNotFoundException {
        return eventService.getEventById(eventId).orElse(null);
    }

    /**
     * Create a new event associated with a specific team.
     *
     * @param eventDto The EventDto representing the new event.
     * @param teamId   The ID of the team associated with the event.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createEvent(@RequestBody EventDto eventDto, Long teamId, List<RunnerDto> runners) throws ConstraintsViolationException, EntityAlreadyExistsException, InvalidIdentifierException {
        Optional<TeamDto> foundTeam = teamService.getTeamById(teamId);
        if(!foundTeam.isPresent()){
            return "Team with that Id was not found, terminating";
        }
        try{
            eventService.createEvent(eventDto, teamId, runners);
        }catch(Exception e) {
            return String.format("Exception occurred: %s", e);
        }
        return "Event successfully created";
    }

    /**
     * Delete an event by its ID.
     *
     * @param eventId The ID of the event to delete.
     */
    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) throws InvalidIdentifierException {
        eventService.deleteEvent(eventId);
    }

    /**
     * Update the details of an existing event.
     *
     * @param eventDto The EventDto representing the updated event details.
     */
    @PutMapping("/{eventId}")
    public void updateEvent(@RequestBody EventDto eventDto, @PathVariable Long eventId) throws InvalidIdentifierException, ConstraintsViolationException{
        Optional<EventDto> foundEvent = eventService.getEventById(eventId);
        if(foundEvent.isPresent()){
            eventService.updateEvent(eventDto);
       }
    }
}
