package test.java.com.javarun.web.service;

import com.javarun.web.dto.RunnerDto;
import com.javarun.web.repository.RunnerRepository;
import com.javarun.web.models.Runner;

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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RunnerServiceTest {
    @Mock
    private RunnerRepository runnerRepository;

    @InjectMocks
    private RunnerServiceImpl runnerService;

    @Test
    public void RunnerService_GetAllRunners_ReturnsResponseDto(){
        Page<Runner> runners = Mockito.mock(Page.class);
        when(runnerRepository.findAll(Mockito.any(Pageable.class))).thenReturn(runners);
        RunnerDto runner = runnerService.getAllRunners();
        Assertions.assertThat(runner).isNotNull();
    }
}