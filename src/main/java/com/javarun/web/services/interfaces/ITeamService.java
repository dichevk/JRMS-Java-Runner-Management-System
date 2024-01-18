package main.java.com.javarun.web.services.interfaces;

import com.javarun.web.dto.RunnerDto;
import com.javarun.web.dto.TeamDto;

public interface ITeamService {

    List<TeamDto> getAllTeams();
    
    Optional<TeamDto> getTeamById(Long teamId);
    
    void createTeam(TeamDto teamDto, List<RunnerDto> runners, List<EventDto> events);

    void deleteTeam(Long teamId);

    void udpateTeam(TeamDto teamDto);
}
