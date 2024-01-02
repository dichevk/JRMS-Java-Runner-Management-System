package com.javarun.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javarun.web.model.History;

public interface HistoryRepository extends JpaRepository<History, Long> {
    
}
