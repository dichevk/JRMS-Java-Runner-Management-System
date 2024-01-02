package com.javarun.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.javarun.web.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{
    
}
