package main.java.com.javarun.web.services;

import com.javarun.web.dto.EventDto;
import com.javarun.web.dto.RunnerDto;
import com.javarun.web.models.History;
import com.javarun.web.models.Runner;
import com.javarun.web.repository.EventRepository;
import com.javarun.web.repository.HistoryRepository;
import com.javarun.web.repository.RunnerRepository;
import com.javarun.web.repository.TeamRepository;
import com.javarun.web.services.interfaces.IRunnerService;
import com.javarun.web.mapper.RunnerMapper.mapToRunner;
import com.javarun.web.mapper.RunnerMapper.mapToRunnerDto;
import com.javarun.web.mapper.EventMapper.mapToEventDto;

import com.javarun.web.dto.EventDto;

import jdk.jfr.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the {@link IRunnerService} interface for managing runners.
 */
@Service
public class RunnerServiceImpl implements IRunnerService {

    private final TeamRepository teamRepository;
    private final RunnerRepository runnerRepository;
    private final EventRepository eventRepository;
    private final HistoryRepository historyRepository;

    /**
     * Constructor to inject the necessary repositories.
     *
     * @param teamRepository     The TeamRepository instance to be injected.
     * @param runnerRepository   The RunnerRepository instance to be injected.
     * @param eventRepository    The EventRepository instance to be injected.
     * @param historyRepository  The HistoryRepository instance to be injected.
     */
    @Autowired
    public RunnerServiceImpl(TeamRepository teamRepository, RunnerRepository runnerRepository,
                             EventRepository eventRepository, HistoryRepository historyRepository) {
        this.teamRepository = teamRepository;
        this.runnerRepository = runnerRepository;
        this.eventRepository = eventRepository;
        this.historyRepository = historyRepository;
    }

    /**
     * Create a new runner associated with a specific team, history, and events.
     *
     * @param runnerDto   The RunnerDto representing the new runner.
     * @param teamId      The ID of the team associated with the runner.
     * @param historyId   The ID of the history associated with the runner.
     * @param events      The list of EventDto representing events associated with the runner.
     */
    @Override
    public void createRunner(RunnerDto runnerDto, Long teamId, Long historyId, List<EventDto> events) {
        Team team = teamRepository.findById(teamId).get();
        History history = historyRepository.findById(historyId).get();
        List<Event>runnerEvents = new List<Event>();
        for(Event event : events){
            EventDto eventDto = mapToEventDto(event);
            runnerEvents.add(eventRepository.findById(eventDto.getId()).get());
        } 
        Runner runner = mapToRunner(runnerDto);
        runner.setTeam(team);
        runner.setHistory(history);
        runner.setEvents(runnerEvents);
        runnerRepository.save(runner);
    }

    /**
     * Delete a runner by its ID.
     *
     * @param runnerId The ID of the runner to delete.
     */
    @Override
    public void deleteRunner(Long runnerId) {
        runnerRepository.deleteById(runnerId);        
    }

    /**
     * Get a list of all runners.
     *
     * @return A list of RunnerDto representing all runners.
     */
    @Override
    public List<RunnerDto> getAllRunners() {
        List<Runner> runnerObjs = runnerRepository.findAll();
        List<RunnerDto> runners = new List<RunnerDto>();
        for(Runner runner : runnerObjs){
            runners.append(mapToRunnerDto(runner));
        }
        return runners;
    }

    /**
     * Get details of a specific runner by its ID.
     *
     * @param runnerId The ID of the runner to retrieve.
     * @return The RunnerDto representing the requested runner, or an empty Optional if not found.
     */
    @Override
    public Optional<RunnerDto> getRunnerById(Long runnerId) {
        return mapToRunnerDto(runnerRepository.findById(runnerId).get());
    }

    /**
     * Update the details of an existing runner.
     *
     * @param runnerDto The RunnerDto representing the updated runner details.
     */
    @Override
    public void updateRunner(RunnerDto runnerDto) {
        Runner runner = mapToRunner(runnerDto);
        runnerRepository.save(runner);
    }
}
