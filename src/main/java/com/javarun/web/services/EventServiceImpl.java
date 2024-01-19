package main.java.com.javarun.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javarun.web.dto.EventDto;
import com.javarun.web.repository.EventRepository;
import com.javarun.web.repository.TeamRepository;
import com.javarun.web.models.Team;
import com.javarun.web.models.Event;
import main.java.com.javarun.web.services.interfaces.IEventService;

import com.javarun.web.mapper.EventMapper.mapToEvent;
import com.javarun.web.mapper.EventMapper.mapToEventDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements IEventService {

    private final EventRepository eventRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public EventService(EventRepository eventRepository, TeamRepository teamRepository) {
        this.eventRepository = eventRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public Optional<EventDto> getEventById(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public void createEvent(EventDto eventDto, Long teamId ) {
        Team team = teamRepository.findById(teamId).get();
        Event event = mapToEvent(eventDto);
        event.setTeam(team);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }
}