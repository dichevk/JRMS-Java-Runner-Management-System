package com.javarun.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javarun.web.models.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
    
}
