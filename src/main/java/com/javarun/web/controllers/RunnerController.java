package main.java.com.javarun.web.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import main.java.com.javarun.web.services.interfaces.IRunnerService;
import com.javarun.web.dto.RunnerDto;

@RestController
@RequestMapping("/runners")
public class RunnerController {
    private final IRunnerService runnerService;

    @Autowired
    public RunnerController(IRunnerService runnerService){
        this.runnerService = runnerService;
    }

    public List<RunnerDto> runners(){
        runnerService.getAllRunners();
    }
}
