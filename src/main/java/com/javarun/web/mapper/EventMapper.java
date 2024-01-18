package com.javarun.web.mapper;

import com.javarun.web.dto.EventDto;
import com.javarun.web.models.Event;

public class EventMapper {
    public static Event mapToEvent(EventDto eventDto) {
        return Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .createdOn(eventDto.getCreatedOn())
                .updatedOn(eventDto.getUpdatedOn())
                .team(eventDto.getTeam())
                .build();
    }

    public static EventDto mapToEventDto(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .type(event.getType())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .team(event.getTeam())
                .build();
    }
}