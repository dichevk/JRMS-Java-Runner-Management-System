package test.java.com.javarun.web.service;

import com.javarun.web.dto.EventDto;
import com.javarun.web.dto.RunnerDto;
import com.javarun.web.repository.RunnerRepository;
import com.javarun.web.repository.TeamRepository;
import com.javarun.web.repository.HistoryRepository;
import com.javarun.web.repository.EventRepository;
import com.javarun.web.models.History;
import com.javarun.web.models.Runner;
import com.javarun.web.models.Team;

import main.java.com.javarun.web.services.RunnerServiceImpl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RunnerServiceTest {
    @Mock
    private RunnerRepository runnerRepository;
    @Mock
    private RunnerRepository teamRepository;
    @Mock
    private RunnerRepository historyRepository;
    @Mock
    private RunnerRepository eventRepository;

    @InjectMocks
    private RunnerServiceImpl runnerService;

    @Test
    public void RunnerService_GetAllRunners_ReturnsResponseDto(){
        Page<Runner> runners = Mockito.mock(Page.class);
        when(runnerRepository.findAll(Mockito.any(Pageable.class))).thenReturn(runners);
        RunnerDto runner = runnerService.getAllRunners();
        Assertions.assertThat(runner).isNotNull();
    }

    @Test
    public void testCreateRunner() {
        // Mock objects
        RunnerDto runnerDto = Mockito.mock(RunnerDto.class);
        Long teamId = 1L;
        Long historyId = 2L;
        List<EventDto> events = Arrays.asList(Mockito.mock(EventDto.class), Mockito.mock(EventDto.class));
        Team team = Mockito.mock(Team.class);
        History history = Mockito.mock(History.class);
        List<Event> runnerEvents = Arrays.asList(Mockito.mock(Event.class), Mockito.mock(Event.class));

        // Mocking repository behavior
        when(teamRepository.findById(teamId)).thenReturn(Optional.of(team));
        when(historyRepository.findById(historyId)).thenReturn(Optional.of(history));
        when(eventRepository.findById(any())).thenReturn(Optional.of(Mockito.mock(Event.class)));
        when(runnerRepository.save(any())).thenReturn(Mockito.mock(Runner.class));

        // Call the method
        runnerService.createRunner(runnerDto, teamId, historyId, events);

        // Verify repository interactions
        verify(teamRepository, times(1)).findById(teamId);
        verify(historyRepository, times(1)).findById(historyId);
        verify(eventRepository, times(events.size())).findById(any());
        verify(runnerRepository, times(1)).save(any());
}
    @Test
    public void testGetAllRunners() {
        List<Runner> runnerObjs = Arrays.asList(Mockito.mock(Runner.class), Mockito.mock(Runner.class));
        Page<Runner> runnersPage = new PageImpl<>(runnerObjs);

        // Mocking repository behavior
        when(runnerRepository.findAll(any(Pageable.class))).thenReturn(runnersPage);

        // Call the method
        Page<RunnerDto> runnerDtoPage = runnerService.getAllRunners(PageRequest.of(0, 10)); // Example page request

        // Verify repository interactions
        verify(runnerRepository, times(1)).findAll(any(Pageable.class));
        assertThat(runnerDtoPage.getContent()).hasSize(2); // Assuming there are 2 runners returned
    }
    @Test
    public void testGetRunnerById() {
        Long runnerId = 1L;
        Runner runner = Mockito.mock(Runner.class);
        when(runnerRepository.findById(runnerId)).thenReturn(Optional.of(runner));
    
        // Call the method
        Optional<RunnerDto> result = runnerService.getRunnerById(runnerId);
    
        // Verify repository interactions
        verify(runnerRepository, times(1)).findById(runnerId);
        assertThat(result).isPresent(); // Assuming the runner with the given ID exists
    }
    

}