package com.javarun.web.mapper;

import com.javarun.web.dto.TeamDto;
import com.javarun.web.models.Team;

public class TeamMapper {
    public static Team mapToTeam(TeamDto teamDto){
        return Team.builder()
            .id(teamDto.getId())
            .title(teamDto.getTitle())
            .content(teamDto.getContent())
            .createdBy(teamDto.getCreatedBy())
            .createdOn(teamDto.getCreatedOn())
            .updatedOn(teamDto.getUpdatedOn())
            .history(teamDto.getHistory())
            .runners(teamDto.getRunners())
            .build();
    }
    public static TeamDto mapToTeamDto(Team team){
        return TeamDto.builder()
            .id(team.getId())
            .title(team.getTitle())
            .content(team.getContent())
            .createdBy(team.getCreatedBy())
            .createdOn(team.getCreatedOn())
            .updatedOn(team.getUpdatedOn())
            .history(team.getHistory())
            .runners(team.getRunners())
            .build();
    }
}
