package main.java.com.javarun.web.services;

import java.util.List;
import java.util.Optional;

import com.javarun.web.dto.EventDto;
import com.javarun.web.dto.RunnerDto;
import com.javarun.web.repository.EventRepository;
import com.javarun.web.repository.HistoryRepository;
import com.javarun.web.repository.RunnerRepository;
import com.javarun.web.repository.TeamRepository;

import main.java.com.javarun.web.services.interfaces.IRunnerService;

public class RunnerServiceImpl implements IRunnerService {

    private final TeamRepository teamRepository;
    private final RunnerRepository runnerRepository;
    private final EventRepository eventRepository;
    private final HistoryRepository historyRepository;

    @Autowired
    public RunnerServiceImpl(TeamRepository teamRepository, RunnerRepository runnerRepository, EventRepository eventRepository, HistoryRepository historyRepository){
        this.teamRepository = teamRepository;
        this.runnerRepository = runnerRepository;
        this.eventRepository = eventRepository;
        this.historyRepository = historyRepository;
    }

    @Override
    public void createRunner(RunnerDto runnerDto, Long teamId, Long historyId, List<EventDto> events) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteRunner(Long runnerId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<RunnerDto> getAllRunners() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<RunnerDto> getRunnerById(Long runnerId) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void udpateRunner(RunnerDto runnerDto) {
        // TODO Auto-generated method stub
        
    }
    
}
