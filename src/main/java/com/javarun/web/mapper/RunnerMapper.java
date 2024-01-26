package main.java.com.javarun.web.mapper;

import com.javarun.web.dto.RunnerDto;
import com.javarun.web.models.Runner;

public class RunnerMapper {
    public static Runner mapToRunner(RunnerDto runnerDto) {
        return Runner.builder()
                .id(runnerDto.getId())
                .history(runnerDto.getHistory())
                .birthDate(runnerDto.getBirthDate())
                .identityId(runnerDto.getIdentityId())
                .name(runnerDto.getName())
                .info(runnerDto.getInfo())
                .name(runnerDto.getName())
                .team(runnerDto.getTeam())
                .number(runnerDto.getNumber())
                .build();
    }

    public static RunnerDto mapToRunnerDto(Runner runner) {
        return RunnerDto.builder()
                .id(runner.getId())
                .history(runner.getHistory())
                .birthDate(runner.getBirthDate())
                .identityId(runner.getIdentityId())
                .name(runner.getName())
                .info(runner.getInfo())
                .name(runner.getName())
                .team(runner.getTeam())
                .number(runner.getNumber())
                .build();
    }
}