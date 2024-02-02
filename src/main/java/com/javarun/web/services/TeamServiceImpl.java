package main.java.com.javarun.web.services;

import java.util.stream.Collectors;

import com.javarun.web.dto.RunnerDto;
import com.javarun.web.dto.TeamDto;
import com.javarun.web.models.History;
import com.javarun.web.models.Team;
import com.javarun.web.repository.TeamRepository;
import com.javarun.web.repository.RunnerRepository;
import com.javarun.web.repository.EventRepository;
import com.javarun.web.repository.HistoryRepository;

import com.javarun.web.mapper.*;

import main.java.com.javarun.web.services.interfaces.EventDto;
import main.java.com.javarun.web.services.interfaces.ITeamService;
import main.java.com.javarun.web.services.interfaces.List;
import main.java.com.javarun.web.services.interfaces.Optional;

public class TeamServiceImpl implements ITeamService {
    private final TeamRepository teamRepository;
    private final RunnerRepository runnerRepository;
    private final EventRepository eventRepository;
    private final HistoryRepository historyRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, RunnerRepository runnerRepository, EventRepository eventRepository, HistoryRepository historyRepository){
        this.teamRepository = teamRepository;
        this.runnerRepository = runnerRepository;
        this.eventRepository = eventRepository;
        this.historyRepository = historyRepository;
    }

    @Override
    public void createTeam(TeamDto teamDto, List<RunnerDto> runners, Long historyId, List<EventDto> events) {
        History history = historyRepository.findById(historyId).get();
        List<Event> eventObjs = events.stream().map(event -> mapToEvent(event)).collect(Collectors.toList());
        List<Runner> runnerObjs = runners.stream().map(runner -> mapToRunner(runner)).collect(Collectors.toList());
        Team team = mapToTeam(teamDto);
        team.setRunners(runnerObjs);
        team.setEvents(eventObjs);
        team.setHistory(history);
        teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Long teamId) {
        Team team = teamRepository.deleteById(teamId);
    }

    @Override
    public List<TeamDto> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        List<TeamDto> teamDtos = teams.stream().map(team -> mapToTeamDto(team)).collect(Collectors.toList());
        return teamDtos;
    }

    @Override
    public Optional<TeamDto> getTeamById(Long teamId) {
        Team team = teamRepository.findById(teamId).get();
        TeamDto teamDto = mapToTeamDto(team);
        return teamDto;
    }

    @Override
    public void udpateTeam(TeamDto teamDto) {
        Team team = mapToTeam(teamDto);
        teamRepository.save(team);
        
    }
    
}
