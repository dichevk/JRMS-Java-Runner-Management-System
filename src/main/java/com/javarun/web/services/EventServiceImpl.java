package main.java.com.javarun.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javarun.web.dto.EventDto;
import com.javarun.web.repository.EventRepository;
import com.javarun.web.repository.TeamRepository;
import com.javarun.web.models.Team;
import com.javarun.web.models.Event;
import main.java.com.javarun.web.services.interfaces.IEventService;
import main.java.com.javarun.web.services.interfaces.RunnerDto;

import com.javarun.web.mapper.EventMapper.mapToEvent;
import com.javarun.web.mapper.EventMapper.mapToEventDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the {@link IEventService} interface for managing events.
 */
@Service
public class EventServiceImpl implements IEventService {

    private final EventRepository eventRepository;
    private final TeamRepository teamRepository;

    /**
     * Constructor to inject the EventRepository and TeamRepository dependencies.
     *
     * @param eventRepository The EventRepository instance to be injected.
     * @param teamRepository  The TeamRepository instance to be injected.
     */
    @Autowired
    public EventService(EventRepository eventRepository, TeamRepository teamRepository) {
        this.eventRepository = eventRepository;
        this.teamRepository = teamRepository;
    }
    /**
     * Get a list of all events.
     *
     * @return A list of EventDto representing all events.
     */
    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }
    /**
     * Get details of a specific event by its ID.
     *
     * @param eventId The ID of the event to retrieve.
     * @return The EventDto representing the requested event, or an empty Optional if not found.
     */

    @Override
    public Optional<EventDto> getEventById(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }
    /**
     * Create a new event associated with a specific team.
     *
     * @param eventDto The EventDto representing the new event.
     * @param teamId The ID of the team associated with the event.
     */
    @Override
    public void createEvent(EventDto eventDto, Long teamId, List<RunnerDto> runnerDtos) {

        Team team = teamRepository.findById(teamId).get();
        Event event = mapToEvent(eventDto);
        event.setTeam(team);
        eventRepository.save(event);
    }

    /**
     * Delete an event by its ID.
     *
     * @param eventId The ID of the event to delete.
     */
    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    /**
     * Update the details of an existing event.
     *
     * @param eventDto The EventDto representing the updated event details.
     */
    @Override
    public void updateEvent(EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }
}