package main.java.com.javarun.web.controllers;

import main.java.com.javarun.web.services.interfaces.ITeamService;
import main.java.com.javarun.web.services.interfaces.IteamService;

import java.util.List;
import java.util.Optional;

import com.javarun.web.dto.EventDto;
import com.javarun.web.dto.TeamDto;
import com.javarun.web.dto.RunnerDto;
import com.javarun.web.dto.CoachDto;

import main.java.com.javarun.web.exceptions.EntityAlreadyExistsException;
import main.java.com.javarun.web.exceptions.EntityNotFoundException;
import main.java.com.javarun.web.exceptions.InvalidIdentifierException;

@RestController
@EnableAsync
@RequestMapping("v1/teams")
public class TeamController {
    private final ITeamService teamService;

    @Autowired
    public TeamController(IteamService teamService){
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAllTeams(){
        List<TeamDto>teams = teamService.getAllTeams();
        if(len(teams)>0){
            return new ResponseEntity<>(teams, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable Long teamId) throws InvalidIdentifierException, EntityNotFoundException{
        Optional<TeamDto> team = teamService.getTeamById(teamId);
        if(team.isPresent()){
            return new ResponseEntity<>(team, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto, Long coachId, Long historyId, List<EventDto>events, List<RunnerDto> runners) throws InvalidIdentifierException, EntityAlreadyExistsException{
       Optional<TeamDto>team = teamService.createTeam(teamDto, coachId, historyId, events, runners);
       if(team.isPresent()){
            return new ResponseEntity<>(team, HttpStatus.CREATED);
       }
       return new ReponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    
    @PutMapping("/{teamId}")
    public ResponseEntity<TeamDto> updateTeam(@RequestBody TeamDto teamDto, @PathVariable Long teamId) throws EntityNotFoundException, ConstraintsViolationException, InvalidIdentifierException{
        Optional<TeamDto>foundTeam = teamService.getTeamById(teamId);
        if(foundTeam.isPresent()){
            if(!foundTeam.equals(teamDto)){
                teamService.udpateTeam(teamDto);
                return new ResponseEntity<>(teamDto, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.METHOD_NOT_ALLOWED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{teamId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTeam(@PathVariable Long teamId) throws InvalidIdentifierException{
        teamService.deleteTeam(teamId);
    }
}
