package main.java.com.javarun.web.services.interfaces;

import com.javarun.web.dto.RunnerDto;
import com.javarun.web.dto.TeamDto;

public interface ITeamService {

    /**
     * @return
     */
    List<TeamDto> getAllTeams();
    
    /**
     * @param teamId
     * @return
     */
    Optional<TeamDto> getTeamById(Long teamId);
    
    /**
     * @param teamDto
     * @param runners
     * @param historyId
     * @param events
     */
    void createTeam(TeamDto teamDto, List<RunnerDto> runners, Long historyId, List<EventDto> events);

    /**
     * @param teamId
     */
    void deleteTeam(Long teamId);

    /**
     * @param teamDto
     */
    void udpateTeam(TeamDto teamDto);
}
