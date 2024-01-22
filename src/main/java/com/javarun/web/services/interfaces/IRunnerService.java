package main.java.com.javarun.web.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.javarun.web.dto.EventDto;
import com.javarun.web.dto.RunnerDto;
import com.javarun.web.dto.TeamDto;

public interface IRunnerService {
    /**
     * @return
     */
    List<RunnerDto> getAllRunners();
    
    /**
     * @param runnerId
     * @return
     */
    Optional<RunnerDto> getRunnerById(Long runnerId);
    
    /**
     * @param runnerDto
     * @param teamId
     * @param historyId
     * @param events
     */
    void createRunner(RunnerDto runnerDto, Long teamId, Long historyId, List<EventDto> events);

    /**
     * @param runnerId
     */
    void deleteRunner(Long runnerId);

    /**
     * @param runnerDto
     */
    void udpateRunner(RunnerDto runnerDto);
}
