package main.java.com.javarun.web.mapper;

import com.javarun.web.dto.CoachDto;
import com.javarun.web.models.Coach;

public class CoachMapper {
    public static CoachDto mapToCoach(CoachDto coachDto) {
        return Coach.builder()
                .id(coachDto.getId())
                .name(coachDto.getName())
                .startTime(coachDto.getStartTime())
                .endTime(coachDto.getEndTime())
                .type(coachDto.getType())
                .createdOn(coachDto.getCreatedOn())
                .updatedOn(coachDto.getUpdatedOn())
                .team(coachDto.getTeam())
                .runners(coachDto.getRunners())
                .build();
    }

    public static CoachDto mapToCoachDto(Coach coach) {
        return CoachDto.builder()
                .id(coach.getId())
                .name(coach.getName())
                .startTime(coach.getStartTime())
                .endTime(coach.getEndTime())
                .type(coach.getType())
                .createdOn(coach.getCreatedOn())
                .updatedOn(coach.getUpdatedOn())
                .team(coach.getTeam())
                .runners(coach.getRunners())
                .build();
    }
}