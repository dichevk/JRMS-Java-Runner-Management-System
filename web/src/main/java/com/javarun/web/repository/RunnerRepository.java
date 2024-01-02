package com.javarun.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javarun.web.model.Runner;
import org.springframework.stereotype.Repository;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, Long>{
    
}
