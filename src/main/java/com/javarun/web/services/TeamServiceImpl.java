package main.java.com.javarun.web.services;

import com.javarun.web.dto.RunnerDto;
import com.javarun.web.dto.TeamDto;
import com.javarun.web.repository.TeamRepository;
import com.javarun.web.repository.RunnerRepository;
import com.javarun.web.repository.EventRepository;

import main.java.com.javarun.web.services.interfaces.EventDto;
import main.java.com.javarun.web.services.interfaces.ITeamService;
import main.java.com.javarun.web.services.interfaces.List;
import main.java.com.javarun.web.services.interfaces.Optional;

public class TeamServiceImpl implements ITeamService {
    private final TeamRepository teamRepository;
    private final RunnerRepository runnerRepository;
    private final EventRepository eventRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, RunnerRepository runnerRepository, EventRepository eventRepository){
        this.teamRepository = teamRepository;
        this.runnerRepository = runnerRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void createTeam(TeamDto teamDto, List<RunnerDto> runners, List<EventDto> events) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteTeam(Long teamId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<TeamDto> getAllTeams() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<TeamDto> getTeamById(Long teamId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void udpateTeam(TeamDto teamDto) {
        // TODO Auto-generated method stub
        
    }
    
}
