package com.javarun.web.dto;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

import com.javarun.web.models.Role;

@Data
public class UserDto {
    private Long id; 
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private List<Role> roles;
}
