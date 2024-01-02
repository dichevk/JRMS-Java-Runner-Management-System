package com.javarun.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.javarun.web.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
