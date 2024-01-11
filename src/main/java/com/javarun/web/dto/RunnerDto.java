package com.javarun.web.dto;

import com.javarun.web.models.History;
import com.javarun.web.models.Team;
import jakarta.validation.constraints.NotEmpty;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RunnerDto{
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String birthDate;
    private String info;
    @NotEmpty
    private String identityId;
    private Integer number;
    private History history;
    private Team team; 
}

