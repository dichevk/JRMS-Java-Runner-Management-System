package com.javarun.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javarun.web.models.Runner;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, Long>{
    
}
