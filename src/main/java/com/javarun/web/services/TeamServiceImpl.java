package main.java.com.javarun.web.services;

import com.javarun.web.dto.EventDto;
import com.javarun.web.dto.RunnerDto;
import com.javarun.web.dto.TeamDto;
import com.javarun.web.mapper.TeamMapper;
import com.javarun.web.mapper.EventMapper;
import com.javarun.web.mapper.RunnerMapper;
import com.javarun.web.models.Event;
import com.javarun.web.models.History;
import com.javarun.web.models.Runner;
import com.javarun.web.models.Team;
import com.javarun.web.repository.EventRepository;
import com.javarun.web.repository.HistoryRepository;
import com.javarun.web.repository.RunnerRepository;
import com.javarun.web.repository.TeamRepository;
import com.javarun.web.repository.CoachRepository;
import com.javarun.web.services.interfaces.ITeamService;

import main.java.com.javarun.web.dto.CoachDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implementation of the {@link ITeamService} interface for managing teams.
 */
@Service
public class TeamServiceImpl implements ITeamService {

    private final TeamRepository teamRepository;
    private final RunnerRepository runnerRepository;
    private final EventRepository eventRepository;
    private final HistoryRepository historyRepository;
    private final CoachRepository coachRepository;

    /**
     * Constructor to inject the necessary repositories.
     *
     * @param teamRepository     The TeamRepository instance to be injected.
     * @param runnerRepository   The RunnerRepository instance to be injected.
     * @param eventRepository    The EventRepository instance to be injected.
     * @param historyRepository  The HistoryRepository instance to be injected.
     * @param coachRepository    The CoachRepository instance to be injected.
     */
    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, RunnerRepository runnerRepository,
                           EventRepository eventRepository, HistoryRepository historyRepository, CoachRepository coachRepository) {
        this.teamRepository = teamRepository;
        this.runnerRepository = runnerRepository;
        this.eventRepository = eventRepository;
        this.historyRepository = historyRepository;
        this.coachRepository = coachRepository;
    }

    /**
     * Create a new team associated with a specific history, runners, and events.
     *
     * @param teamDto   The TeamDto representing the new team.
     * @param runners   The list of RunnerDto representing runners associated with the team.
     * @param historyId The ID of the history associated with the team.
     * @param events    The list of EventDto representing events associated with the team.
     */
    @Override
    public Optional<TeamDto> createTeam(@RequestBody TeamDto teamDto, Long coachId, Long historyId, List<RunnerDto> runners, List<EventDto> events) {
        // Placeholder implementation - Replace with actual logic
        History history = historyRepository.findById(historyId).get();
        Coach coach = coachRepository.findById(coachId).get();
        if (!Objects.isNull(history) && !Objects.isNull(coach)) {
            List<Event> eventObjs = events.stream().map(EventMapper::mapToEvent).collect(Collectors.toList());
            List<Runner> runnerObjs  = events.stream().map(RunnerMapper::mapToRunner).collect(Collectors.toList());
            Team team = TeamMapper.mapToTeam(teamDto);
            team.setRunners(runnerObjs);
            team.setEvents(eventObjs);
            team.setHistory(history);
            team.setCoach(coach);
            teamRepository.save(team);
            return teamDto;
        }
    }

    /**
     * Delete a team by its ID.
     *
     * @param teamId The ID of the team to delete.
     */
    @Override
    public void deleteTeam(Long teamId) {
        // Placeholder implementation - Replace with actual logic
        teamRepository.deleteById(teamId);
    }

    /**
     * Get a list of all teams.
     *
     * @return A list of TeamDto representing all teams.
     */
    @Override
    public List<TeamDto> getAllTeams() {
        // Placeholder implementation - Replace with actual logic
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(TeamMapper::mapToTeamDto).collect(Collectors.toList());
    }

    /**
     * Get details of a specific team by its ID.
     *
     * @param teamId The ID of the team to retrieve.
     * @return The TeamDto representing the requested team, or null if not found.
     */
    @Override
    public Optional<TeamDto> getTeamById(Long teamId) {
        // Placeholder implementation - Replace with actual logic
        Team team = teamRepository.findById(teamId).orElse(null);
        return Optional.ofNullable(TeamMapper.mapToTeamDto(team));
    }

    /**
     * Update the details of an existing team.
     *
     * @param teamDto The TeamDto representing the updated team details.
     */
    @Override
    public void updateTeam(TeamDto teamDto) {
        // Placeholder implementation - Replace with actual logic
        Team team = TeamMapper.mapToTeam(teamDto);
        teamRepository.save(team);
    }
}
