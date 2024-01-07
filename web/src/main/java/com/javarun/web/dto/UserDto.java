package com.javarun.web.dto;

import lombok.Data;
import com.javarun.web.model.Role;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

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
