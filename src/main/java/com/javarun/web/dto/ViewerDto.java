package com.javarun.web.dto;

import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;

import javax.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ViewerDto {
    private Long id;
    @NotEmpty
    private String passId; 
    @NotEmpty
    private String name;
    private String country;
    @NotEmpty
    private String iban;
    private Event event; 
}
