package main.java.com.javarun.web.controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import main.java.com.javarun.web.controllers.exceptions.*;
import main.java.com.javarun.web.services.interfaces.IEventService;
import main.java.com.javarun.web.services.interfaces.IRunnerService;
import com.javarun.web.dto.RunnerDto;

@RestController
@RequestMapping("v1/runners")
public class RunnerController {
    private final IRunnerService runnerService;

    @Autowired
    public RunnerController(IRunnerService runnerService){
        this.runnerService = runnerService;
    }
    @GetMapping
    public List<RunnerDto> runners(){
        runnerService.getAllRunners();
    }
    @GetMapping("/{runnerId}")
    public Optional<RunnerDto> getRunner(@PathVariable Long runnerId) throws InvalidIdentifierException, EntityNotFoundException{
        Optional<RunnerDto> foundRunner = runnerService.getRunnerById(runnerId);
        if(foundRunner.isPresent()){
            return foundRunner;
        }
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRunner(RunnerDto runnerDto, Long teamId, Long historyId, List<EventDto>events) throws InvalidIdentifierException, EntityAlreadyExistsException{
        runnerService.createRunner(runnerDto, teamId, historyId, events);
    }
    @PutMapping("/{runnerId}")
    public RunnerDto updateRunner(RunnerDto runnerDto, @PathVariable Long runnerId) throws EntityNotFoundException, ConstraintsViolationException, InvalidIdentifierException{
        Optional<RunnerDto>foundRunner = runnerService.getRunnerById(runnerId);
        if(foundRunner.isPresent()){
            runnerService.udpateRunner(runnerDto);
        }
        Optional<RunnerDto> updatedRunner = runnerService.getRunnerById(runnerId);
        if(updatedRunner.isPresent()){
            if(!updatedRunner.equals(foundRunner)){
                return updatedRunner;
            }
        }
    }

    @DeleteMapping("/{runnerId}")
    public String deleteRunner(@PathVariable Long runnerId) throws InvalidIdentifierException{
        Optional<RunnerDto> foundRunner = runnerService.getRunnerById(runnerId);
        if (!foundRunner.isPresent()){
            return "Runner with that Id was not found";
        }
        runnerService.deleteRunner(runnerId);
        return "Runner successfully deleted";
    }
}
