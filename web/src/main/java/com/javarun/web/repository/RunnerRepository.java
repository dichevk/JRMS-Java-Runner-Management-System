package com.javarun.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javarun.web.model.Runner;

public interface RunnerRepository extends JpaRepository<Runner, Long>{
    
}
