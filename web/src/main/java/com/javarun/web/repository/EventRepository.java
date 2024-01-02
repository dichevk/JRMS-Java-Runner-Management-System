package com.javarun.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javarun.web.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
    
}
