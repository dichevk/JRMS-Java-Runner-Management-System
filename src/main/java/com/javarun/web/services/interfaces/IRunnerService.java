package main.java.com.javarun.web.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.javarun.web.dto.EventDto;
import com.javarun.web.dto.RunnerDto;
import com.javarun.web.dto.TeamDto;

public interface IRunnerService {
    /**
     * Get a list of all runners.
     *
     * @return A list of RunnerDto representing all runners.
     */
    List<RunnerDto> getAllRunners();
    
    /**
     * Get details of a specific runner by its ID.
     *
     * @param runnerId The ID of the runner to retrieve.
     * @return The RunnerDto representing the requested runner, or an empty Optional if not found.
     */
    Optional<RunnerDto> getRunnerById(Long runnerId);
    
    /**
     * Create a new runner associated with a specific team, history, and events.
     *
     * @param runnerDto   The RunnerDto representing the new runner.
     * @param teamId      The ID of the team associated with the runner.
     * @param historyId   The ID of the history associated with the runner.
     * @param events      The list of EventDto representing events associated with the runner.
     */
    void createRunner(RunnerDto runnerDto, Long teamId, Long historyId, List<EventDto> events);

    /**
     * Delete a runner by its ID.
     *
     * @param runnerId The ID of the runner to delete.
     */
    void deleteRunner(Long runnerId);

    /**
     * Update the details of an existing runner.
     *
     * @param runnerDto The RunnerDto representing the updated runner details.
     */
    void updateRunner(RunnerDto runnerDto);
}
