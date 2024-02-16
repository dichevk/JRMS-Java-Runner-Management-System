package main.java.com.javarun.web.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.javarun.web.dto.EventDto;
import com.javarun.web.dto.RunnerDto;
import com.javarun.web.dto.TeamDto;

public interface ITeamService {

    /**
     * Get a list of all teams.
     *
     * @return A list of TeamDto representing all teams.
     */
    List<TeamDto> getAllTeams();
    
    /**
     * Get details of a specific team by its ID.
     *
     * @param teamId The ID of the team to retrieve.
     * @return The TeamDto representing the requested team, or null if not found.
     */
    Optional<TeamDto> getTeamById(Long teamId);
    
    /**
     * Create a new team associated with a specific history, runners, and events.
     *
     * @param teamDto   The TeamDto representing the new team.
     * @param runners   The list of RunnerDto representing runners associated with the team.
     * @param historyId The ID of the history associated with the team.
     * @param events    The list of EventDto representing events associated with the team.
     * @param coachId   The id of the coach associated with the team. 
     */
    Optional<TeamDto> createTeam(TeamDto teamDto, Long coachId, Long historyId, List<EventDto> events, List<RunnerDto> runners);

    /**
     * Delete a team by its ID.
     *
     * @param teamId The ID of the team to delete.
     */
    void deleteTeam(Long teamId);

    /**
     * Update the details of an existing team.
     *
     * @param teamDto The TeamDto representing the updated team details.
     */
    void udpateTeam(TeamDto teamDto);
}
